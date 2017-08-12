package com.jiangkunbo.common.base;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by Administrator on 2017/8/12.
 */

public class BaseApplication extends Application {
    private static BaseApplication instance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static BaseApplication getInstance() {
        return instance;
    }
    public static Resources getAppResources() {
        return instance.getResources();
    }
}
