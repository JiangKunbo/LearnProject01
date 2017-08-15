package com.klivitam.mypractisedemo.ui.news.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.news.model.HomeNewFragmentModel;


/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragmentPresent extends BasePresent<IHomeNewsContract.View,IHomeNewsContract.Model> implements IHomeNewsContract.Present{



    @Override
    public void start() {

    }

    @Override
    protected IHomeNewsContract.Model loadModels(BasePresent<IHomeNewsContract.View, IHomeNewsContract.Model> viewModelBasePresent, Context context) {
        return new HomeNewFragmentModel(this,getContext());
    }
}