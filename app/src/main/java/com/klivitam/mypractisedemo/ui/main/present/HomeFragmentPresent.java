package com.klivitam.mypractisedemo.ui.main.present;

import android.content.Context;
import android.support.annotation.MainThread;
import android.util.Log;

import com.jiangkunbo.bean.MsgEvent;
import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.ui.main.frag.HomeFragment;
import com.klivitam.mypractisedemo.ui.main.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.main.model.HomeFragmentModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragmentPresent extends BasePresent<IHomeContract.View, IHomeContract.Model> implements IHomeContract.Present {


    @Override
    public void start() {
        List<String> mList = new ArrayList<>();
        List<NewChannelBean> list = getModels().loadTabList();
        for (int i = 0; i < list.size(); i++) {
            mList.add(list.get(i).getChannelName());
        }
        getViews().initTab(mList,list);
    }

    @Override
    protected IHomeContract.Model loadModels(BasePresent<IHomeContract.View, IHomeContract.Model> viewModelBasePresent, Context context) {
        return new HomeFragmentModel(this, getContext());
    }


}
