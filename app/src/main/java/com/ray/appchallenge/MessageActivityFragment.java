package com.ray.appchallenge;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ray.appchallenge.dto.Msg;
import com.ray.appchallenge.http.ApiServiceImpl;

import java.util.List;

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
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

//        ApiServiceImpl api =  new ApiServiceImpl();
//        retrofit2.Call<List<Msg>> call = api.getList(0);
//        call.enqueue(new Callback<List<Msg>>() {
//            @Override
//            public void onResponse(retrofit2.Call<List<Msg>> call, Response<List<Msg>> response) {
//                int i =1+1;
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<List<Msg>> call, Throwable t) {
//                int i =1+1;
//            }
//        });
    }
}
