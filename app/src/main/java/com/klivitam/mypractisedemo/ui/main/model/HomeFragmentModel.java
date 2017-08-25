package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiangkunbo.common.utills.SPUtils;
import com.klivitam.mypractisedemo.MyApplication;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.api.ApiConstants;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.ui.main.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.main.present.HomeFragmentPresent;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_TAB;
import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_TAB_CHANGE;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragmentModel implements IHomeContract.Model {
    private Context context;
    private HomeFragmentPresent present;

    public HomeFragmentModel(HomeFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }

    @Override
    public List<NewChannelBean> loadTabList() {
        List<NewChannelBean> list;
        Gson gson = new Gson();
        if (null != SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB) &&
                SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB).length() > 0) {
            Log.i("", "loadTabList111: " + SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB));
            Type type = new TypeToken<List<NewChannelBean>>() {
            }.getType();
            list = gson.fromJson(SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB), type);
        } else {
            list = new ArrayList<>();
            List<String> s = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_name_static));
            List<String> s1 = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_id_static));
            for (int i = 0; i < s.size(); i++) {
                NewChannelBean bean = new NewChannelBean(s1.get(i), s.get(i), true,ApiConstants.getType(s1.get(i)));
                list.add(bean);
            }
            SPUtils.setSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB, gson.toJson(list));
            Log.i("String", "loadTabList: " + SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB));

            List<NewChannelBean> list1 = new ArrayList<>();
            List<String> s2 = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_name));
            List<String> s3 = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.news_channel_id));
            for (int i = 0; i < s2.size(); i++) {
                NewChannelBean bean = new NewChannelBean(s3.get(i), s2.get(i), false, ApiConstants.getType(s3.get(i)));
                list1.add(bean);
            }
            SPUtils.setSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB_CHANGE, gson.toJson(list1));
            Log.i("String", "loadTabList1: " + SPUtils.getSharedStringData(MyApplication.getInstance(), FRAGMENT_TAB_CHANGE));

        }
        return list;
    }
}
