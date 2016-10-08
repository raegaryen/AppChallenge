package com.ray.appchallenge.http;

import com.ray.appchallenge.dto.Msg;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @author Raymond Chenon
 */

public class ApiServiceImpl {

    private APIService service;

    public ApiServiceImpl(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                //.addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }

    public Call<List<Msg>> getList(final int page){
        return service.getList(page);
    }
}
