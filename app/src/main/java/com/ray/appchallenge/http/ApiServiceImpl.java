package com.ray.appchallenge.http;

import java.io.File;
import java.io.IOException;

import java.util.List;

import com.ray.appchallenge.http.dto.Msg;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author  Raymond Chenon
 */

public class ApiServiceImpl {

    private APIService service;
    private OkHttpClient client;

    private final String BASE_URL = "https://rawgit.com/zbsz/test_app/master/";

    // test the inline image
// private final String BASE_URL = "https://raw.githubusercontent.com/raegaryen/AppChallenge/master/download/";

    public ApiServiceImpl(final File cacheDir) {

        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(cacheDir, cacheSize);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(final Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder().addHeader("Cache-Control",
                            String.format("max-age=%d", 50000));

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

        client = new OkHttpClient.Builder().cache(cache).build();

        initRetrofit();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                                                  .client(client).build();

        service = retrofit.create(APIService.class);
    }

    public Call<List<Msg>> getList(final int page) {
        return service.getList(page);
    }
}
