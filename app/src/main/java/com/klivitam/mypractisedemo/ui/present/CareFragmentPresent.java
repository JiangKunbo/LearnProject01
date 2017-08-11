package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.klivitam.mypractisedemo.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.model.CareFragmentModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class CareFragmentPresent extends BasePresent<ICareContract.View,ICareContract.Model> implements ICareContract.Present{


    @Override
    public void start() {

    }

    @Override
    protected ICareContract.Model loadModels(BasePresent<ICareContract.View, ICareContract.Model> viewModelBasePresent, Context context) {
        return new CareFragmentModel(this,getContext());
    }
}
