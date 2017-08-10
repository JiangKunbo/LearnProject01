package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.klivitam.mypractisedemo.base.BasePresent;
import com.klivitam.mypractisedemo.base.imp.IContract;
import com.klivitam.mypractisedemo.ui.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.model.HomeModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomePresent extends BasePresent<IHomeContract.View,IHomeContract.Model> implements IHomeContract.Present{


    @Override
    public void start() {

    }

    @Override
    protected IHomeContract.Model loadModels(BasePresent<IHomeContract.View, IHomeContract.Model> viewModelBasePresent, Context context) {
        return new HomeModel(this,getContext());
    }
}
