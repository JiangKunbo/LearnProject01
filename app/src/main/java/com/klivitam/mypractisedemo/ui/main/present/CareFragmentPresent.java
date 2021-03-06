package com.klivitam.mypractisedemo.ui.main.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.main.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.main.model.CareFragmentModel;

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
