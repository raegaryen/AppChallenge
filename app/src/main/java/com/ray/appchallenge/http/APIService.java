package com.ray.appchallenge.http;

import com.ray.appchallenge.dto.Msg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    @GET("master/{id}.json")
    Call<List<Msg>> getList(@Path("id") int page);
}
