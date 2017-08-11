package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.klivitam.mypractisedemo.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.imp.IHomeNewsContract;

/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragmentPresent extends BasePresent<IHomeNewsContract.View,IHomeNewsContract.Model> implements IHomeNewsContract.Present{



    @Override
    public void start() {

    }

    @Override
    protected IHomeNewsContract.Model loadModels(BasePresent<IHomeNewsContract.View, IHomeNewsContract.Model> viewModelBasePresent, Context context) {
        return null;
    }
}
