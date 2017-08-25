package com.klivitam.mypractisedemo.ui.news.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiangkunbo.common.utills.SPUtils;
import com.klivitam.mypractisedemo.MyApplication;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeChannel;
import com.klivitam.mypractisedemo.ui.news.present.HomeChannelPresent;


import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_TAB;
import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_TAB_CHANGE;

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
    public List<NewChannelBean> loadSelectItem() {
        List<NewChannelBean> list;
        Gson gson = new Gson();
        Type type = new TypeToken<List<NewChannelBean>>() {
        }.getType();
        list = gson.fromJson(SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB), type);
        return list;
    }

    @Override
    public List<NewChannelBean> loadMoreItem() {
        List<NewChannelBean> list;
        Gson gson = new Gson();
        Type type = new TypeToken<List<NewChannelBean>>() {
        }.getType();
        list = gson.fromJson(SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB_CHANGE), type);
        return list;
    }
}
