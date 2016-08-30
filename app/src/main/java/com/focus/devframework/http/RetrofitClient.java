package com.focus.devframework.http;

import com.focus.devframework.utils.NetworkUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * the single instance of retrofit.
 */
public enum  RetrofitClient {
    /**
     * single instance.
     */
    INSTANCE;
    private final Retrofit mRetrofit;
    private static Object mLock = new Object();
    //BaseUrl 后面 必须后缀 '/'
    private static String BaseUrl = "http://192.168.36.163/";
    RetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.INSTANCE.getOkHttpClient())

                //baseUrl
                .baseUrl(NetworkUtil.protocol + NetworkUtil.airIp)

                //jackson转化器
                .addConverterFactory(JacksonConverterFactory.create())

                //Rxandroid
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
