package com.klivitam.mypractisedemo.ui.main.present;

import android.content.Context;
import android.support.annotation.MainThread;
import android.util.Log;

import com.jiangkunbo.bean.MsgEvent;
import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.main.frag.HomeFragment;
import com.klivitam.mypractisedemo.ui.main.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.main.model.HomeFragmentModel;



/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragmentPresent extends BasePresent<IHomeContract.View,IHomeContract.Model> implements IHomeContract.Present{


    @Override
    public void start() {
        getViews().initTab(getModels().loadTabList());

    }

    @Override
    protected IHomeContract.Model loadModels(BasePresent<IHomeContract.View, IHomeContract.Model> viewModelBasePresent, Context context) {
        return new HomeFragmentModel(this,getContext());
    }
}
