package com.ray.appchallenge;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ray.appchallenge.dto.Msg;
import com.ray.appchallenge.http.ApiServiceImpl;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MessageActivityFragment extends Fragment {

    public MessageActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
    }

    @OnClick(R.id.activate_button)
    public void request(){
        ApiServiceImpl api =  new ApiServiceImpl();
        Call<List<Msg>> call = api.getList(0);
        call.enqueue(new Callback<List<Msg>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Msg>> call, Response<List<Msg>> response) {
                showMsg("onResponse");
            }

            @Override
            public void onFailure(retrofit2.Call<List<Msg>> call, Throwable t) {
                showMsg("onFailure");
            }
        });
    }

    private void showMsg(final String m){
        Snackbar.make(getView(),m, Snackbar.LENGTH_LONG).show();
    }

}
