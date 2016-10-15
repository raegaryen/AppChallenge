package com.ray.appchallenge.http;

import java.util.List;

import com.ray.appchallenge.dto.Msg;

import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author  Raymond Chenon
 */

public class ApiServiceImpl {

    private APIService service;

    public ApiServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://rawgit.com/zbsz/test_app/master/")
                                                  .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(APIService.class);
    }

    public Call<List<Msg>> getList(final int page) {
        return service.getList(page);
    }
}
