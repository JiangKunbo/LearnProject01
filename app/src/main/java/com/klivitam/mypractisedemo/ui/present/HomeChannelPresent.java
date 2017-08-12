package com.klivitam.mypractisedemo.ui.present;

import android.content.Context;

import com.klivitam.mypractisedemo.base.BasePresent;
import com.klivitam.mypractisedemo.ui.imp.IHomeChannel;
import com.klivitam.mypractisedemo.ui.model.HomeChannelModel;

/**
 * Created by klivitam on 17-8-12.
 */

public class HomeChannelPresent extends BasePresent<IHomeChannel.View,IHomeChannel.Model> implements IHomeChannel.Present {

    @Override
    public void start() {
        getViews().showSelectItem(getModels().loadSelectItem());
        getViews().showMoreItem(getModels().loadMoreItem());

    }

    @Override
    protected IHomeChannel.Model loadModels(BasePresent<IHomeChannel.View, IHomeChannel.Model> viewModelBasePresent, Context context) {
        return new HomeChannelModel(this,getContext());
    }
}

