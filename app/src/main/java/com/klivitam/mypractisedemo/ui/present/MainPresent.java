package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.klivitam.mypractisedemo.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.model.MainModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class MainPresent extends BasePresent<IMainContract.View,IMainContract.Model> implements IMainContract.Present {
    @Override
    public void start() {

    }

    @Override
    protected IMainContract.Model loadModels(BasePresent<IMainContract.View, IMainContract.Model> viewModelBasePresent, Context context) {
        return new MainModel(this,getContext());
    }
}
