package com.ray.appchallenge.http;

import java.util.List;

import com.ray.appchallenge.dto.Msg;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    @GET("{id}.json")
    Call<List<Msg>> getList(@Path("id") int page);
}
