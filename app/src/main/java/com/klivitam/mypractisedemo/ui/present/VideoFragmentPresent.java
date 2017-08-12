package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.model.VideoFragmentModel;

/**
 * Created by klivitam on 17-8-10.
 */

public class VideoFragmentPresent extends BasePresent<IVideoContract.View,IVideoContract.Model> implements IVideoContract.Present{


    @Override
    public void start() {

    }

    @Override
    protected IVideoContract.Model loadModels(BasePresent<IVideoContract.View, IVideoContract.Model> viewModelBasePresent, Context context) {
        return new VideoFragmentModel(this,getContext());
    }
}
