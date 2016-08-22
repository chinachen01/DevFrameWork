package com.focus.devframework.http;

import com.focus.devframework.utils.NetworkUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by focus on 16/8/19.
 */
public enum  RetrofitClient {
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

                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())

                //Rxandroid
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
