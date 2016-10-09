package com.ray.appchallenge;

import java.util.List;

import com.ray.appchallenge.adapter.MsgAdapter;
import com.ray.appchallenge.dto.Msg;
import com.ray.appchallenge.http.ApiServiceImpl;

import android.os.Bundle;

import android.support.annotation.Nullable;

import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MessageActivityFragment extends Fragment {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    int page = 0;

    private MsgAdapter msgAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refreshItems();
                }
            });

        request();
    }

    private void refreshItems() {
        page++;
        request();
    }

    public void request() {
        ApiServiceImpl api = new ApiServiceImpl();
        Call<List<Msg>> call = api.getList(page);
        call.enqueue(new Callback<List<Msg>>() {
                @Override
                public void onResponse(final retrofit2.Call<List<Msg>> call, final Response<List<Msg>> response) {
                    showMsg("onResponse");
                    if (page == 0) {
                        initRecyclerView(response.body());
                    } else {
                        onItemsLoadComplete(response.body());
                    }
                }

                @Override
                public void onFailure(final retrofit2.Call<List<Msg>> call, final Throwable t) {
                    showMsg("onFailure");
                }
            });
    }

    private void onItemsLoadComplete(final List<Msg> list) {
        msgAdapter.addItems(list);
        swipeRefreshLayout.setRefreshing(false);
        synchronized (msgAdapter) {
            msgAdapter.notifyDataSetChanged();
        }

    }

    private void initRecyclerView(final List<Msg> list) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        msgAdapter = new MsgAdapter(list);
        recyclerView.setAdapter(msgAdapter);
    }

    private void showMsg(final String m) {
        Snackbar.make(getView(), m, Snackbar.LENGTH_LONG).show();
    }

}
