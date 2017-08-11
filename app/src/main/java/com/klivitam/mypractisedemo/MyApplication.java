package com.klivitam.mypractisedemo;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by klivitam on 17-8-11.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication = null;

    public static MyApplication getApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication = this;
    }

}
