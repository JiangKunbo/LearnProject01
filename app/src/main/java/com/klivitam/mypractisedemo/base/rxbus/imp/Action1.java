package com.klivitam.mypractisedemo.base.rxbus.imp;



/**
 * Created by klivitam on 17-8-12.
 */

public interface Action1<T> extends Action {
    void call(T t);
}
