package com.focus.devframework;

import android.app.Application;
import android.content.Context;

/**
 * Created by focus on 16/8/19.
 */
public class DevApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

}
