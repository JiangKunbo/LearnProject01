package com.jiangkunbo.common.base.imp;

import android.content.Context;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IContract {
    interface IView{

    }
    interface IPresent<V extends IView>{
        void attachView(V views, Context context);
        void detchView();
        void start();
    }
    interface IModel{

    }
}
