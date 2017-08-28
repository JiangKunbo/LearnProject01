package com.klivitam.mypractisedemo.ui.video.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.ui.video.imp.IVideosItemContract;
import com.klivitam.mypractisedemo.ui.video.model.VideoItemModel;

/**
 * Created by klivitam on 17-8-28.
 */

public class VideoItemPresent extends BasePresent<IVideosItemContract.View,IVideosItemContract.Model> implements IVideosItemContract.Present{
    @Override
    public void start() {

    }

    @Override
    protected IVideosItemContract.Model loadModels(BasePresent<IVideosItemContract.View, IVideosItemContract.Model> viewModelBasePresent, Context context) {
        return new VideoItemModel();
    }
}
