package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.model.MainActivityModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class MainActivityPresent extends BasePresent<IMainContract.View,IMainContract.Model> implements IMainContract.Present {
    @Override
    public void start() {

    }

    @Override
    protected IMainContract.Model loadModels(BasePresent<IMainContract.View, IMainContract.Model> viewModelBasePresent, Context context) {
        return new MainActivityModel(this,getContext());
    }
}
