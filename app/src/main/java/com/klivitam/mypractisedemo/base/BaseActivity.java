package com.klivitam.mypractisedemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.klivitam.mypractisedemo.base.imp.IContract;

import butterknife.ButterKnife;

/**
 * Created by klivitam on 17-8-10.
 */

public abstract class BaseActivity<P extends IContract.IPresent> extends AppCompatActivity implements IContract.IView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if(presenter==null){
            presenter = loadPresent();
            presenter.attachView(this,getApplication());
            presenter.start();
        }
        initEventandDatas();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detchView();
        }
    }

    protected abstract void initEventandDatas();

    protected abstract P loadPresent();
    
    protected abstract int getLayoutId();

    public P getPresenter() {
        return presenter;
    }

}
