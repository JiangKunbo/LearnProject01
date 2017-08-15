package com.klivitam.mypractisedemo.ui.main.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.model.BeautiFragmentModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class BeautiFragmentPresent extends BasePresent<IBeautiContract.View,IBeautiContract.Model> implements IBeautiContract.Present{


    @Override
    public void start() {

    }

    @Override
    protected IBeautiContract.Model loadModels(BasePresent<IBeautiContract.View, IBeautiContract.Model> viewModelBasePresent, Context context) {
        return new BeautiFragmentModel(getContext(),this);
    }
}
