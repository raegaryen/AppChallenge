package com.ray.appchallenge;

import java.text.MessageFormat;

import java.util.List;

import com.ray.appchallenge.adapter.AdapterFactory;
import com.ray.appchallenge.http.ApiServiceImpl;
import com.ray.appchallenge.http.dto.Msg;
import com.ray.appchallenge.model.MsgTransformer;
import com.ray.appchallenge.swipetodelete.SimpleItemTouchHelperCallback;
import com.ray.appchallenge.view.SwipeRefreshLayoutBottom;

import android.os.Bundle;

import android.support.annotation.Nullable;

import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

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
    SwipeRefreshLayoutBottom swipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    int page = 0;

    private AdapterFactory msgAdapter;
    private ItemTouchHelper itemTouchHelper;
    private MsgTransformer transformer;

    private ApiServiceImpl api;

    private final int PAGE_LIMIT = 404;

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

        initRecyclerView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutBottom.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refreshItems();
                }
            });

        transformer = new MsgTransformer();
        api = new ApiServiceImpl(getActivity().getApplicationContext());

        request();
    }

    private void refreshItems() {
        if (page < PAGE_LIMIT) {
            page++;
        }

        request();
    }

    public void request() {

        Call<List<Msg>> call = api.getList(page);
        call.enqueue(new Callback<List<Msg>>() {
                @Override
                public void onResponse(final retrofit2.Call<List<Msg>> call, final Response<List<Msg>> response) {
                    showMsg(MessageFormat.format(getString(R.string.success_page), page));

                    onItemsLoadComplete(response.body());
                }

                @Override
                public void onFailure(final retrofit2.Call<List<Msg>> call, final Throwable t) {
                    showMsg(getString(R.string.error));
                }
            });
    }

    private void onItemsLoadComplete(final List<Msg> list) {
        swipeRefreshLayout.setRefreshing(false);

        if (list == null || list.isEmpty()) {
            return;
        }

        msgAdapter.addItems(transformer.transform(list));

        synchronized (msgAdapter) {
            msgAdapter.notifyDataSetChanged();
        }

    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        msgAdapter = new AdapterFactory(getActivity());
        recyclerView.setAdapter(msgAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(msgAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void showMsg(final String m) {
        Snackbar.make(getView(), m, Snackbar.LENGTH_LONG).show();
    }

}
