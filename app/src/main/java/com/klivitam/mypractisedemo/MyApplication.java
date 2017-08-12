package com.klivitam.mypractisedemo;



import com.jiangkunbo.common.base.BaseApplication;
import com.jiangkunbo.common.utills.LogUtils;

/**
 * Created by klivitam on 17-8-11.
 */

public class MyApplication extends BaseApplication {

    public MyApplication() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
//        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}
