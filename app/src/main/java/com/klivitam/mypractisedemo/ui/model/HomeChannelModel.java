package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.MyApplication;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.imp.IHomeChannel;
import com.klivitam.mypractisedemo.ui.present.CareFragmentPresent;
import com.klivitam.mypractisedemo.ui.present.HomeChannelPresent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by klivitam on 17-8-12.
 */

public class HomeChannelModel implements IHomeChannel.Model {
    private Context context;
    private HomeChannelPresent present;

    public HomeChannelModel(HomeChannelPresent present, Context context) {
        this.context = context;
        this.present = present;
    }

    @Override
    public List<String> loadSelectItem() {
        return Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_name_static));
    }

    @Override
    public List<String> loadMoreItem() {
        return Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_name));
    }
}
