package com.ray.appchallenge.http;

import java.io.IOException;

import java.util.List;

import com.ray.appchallenge.http.dto.Msg;
import com.ray.appchallenge.util.NetworkUtil;

import android.content.Context;

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

    public ApiServiceImpl(final Context context) {

        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        client = httpClient.addInterceptor(new CachingControlInterceptor(context)).cache(cache).build();

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

    static class CachingControlInterceptor implements Interceptor {

        private Context context;

        public CachingControlInterceptor(final Context context) {
            this.context = context;
        }

        @Override
        public Response intercept(final Chain chain) throws IOException {
            Request request = chain.request();
            if (NetworkUtil.isNetworkAvailable(context)) {
                request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
            } else {
                request = request.newBuilder()
                                 .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7)
                                 .build();
            }

            return chain.proceed(request);
        }
    }
}
