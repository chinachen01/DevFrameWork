package com.focus.devframework.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by focus on 16/8/19.
 */
public enum  RetrofitClient {
    INSTANCE;
    private final Retrofit mRetrofit;
    private static Object mLock = new Object();

    RetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.INSTANCE.getOkHttpClient())

                //baseUrl
                .baseUrl("")

                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())

                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
