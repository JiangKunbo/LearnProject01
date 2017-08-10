package com.klivitam.mypractisedemo;


import com.klivitam.mypractisedemo.base.BaseActivity;
import com.klivitam.mypractisedemo.ui.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.present.MainPresent;


public class MainActivity extends BaseActivity<MainPresent> implements IMainContract.View {

    @Override
    protected void initEventandDatas() {

    }

    @Override
    protected MainPresent loadPresent() {
        return new MainPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
