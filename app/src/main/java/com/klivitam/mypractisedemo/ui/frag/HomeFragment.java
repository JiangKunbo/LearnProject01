package com.klivitam.mypractisedemo.ui.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.base.BaseFragment;
import com.klivitam.mypractisedemo.ui.act.HomeLabelChannelActivity;
import com.klivitam.mypractisedemo.ui.adapter.MyNewsFragmentAdapter;
import com.klivitam.mypractisedemo.ui.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.present.HomeFragmentPresent;
import com.klivitam.mypractisedemo.utils.TabUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragment extends BaseFragment<IHomeContract.Present> implements IHomeContract.View {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.add_channel_iv)
    ImageView addChannelIv;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private MyNewsFragmentAdapter adapter;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        Log.i("klivitam", "initEventandDatas: ");

    }

    @OnClick({R.id.fab})
    public void onBottomClick(View view) {

    }

    @OnClick({R.id.add_channel_iv})
    public void addChannel(View view) {
        startActivity(new Intent(getActivity(),HomeLabelChannelActivity.class));

    }

    @Override
    protected IHomeContract.Present loadPresent() {
        return new HomeFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initTab(List<String> tab_datas) {
        if(tab_datas!=null){
            adapter = new MyNewsFragmentAdapter(getChildFragmentManager(),getFragmentList(tab_datas.size()),tab_datas);
        }
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        TabUtils.dynamicSetTabLayoutMode(tabs);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<Fragment> getFragmentList(int size) {
        List<Fragment> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            Fragment f = new HomeNewsFragment();
            list.add(f);
        }
        return list;
    }
}
