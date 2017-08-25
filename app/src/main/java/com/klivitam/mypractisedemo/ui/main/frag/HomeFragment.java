package com.klivitam.mypractisedemo.ui.main.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.jiangkunbo.common.base.BaseFragment;
import com.jiangkunbo.common.base.BaseFragmentAdapter;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.bean.NewsContentBean;
import com.klivitam.mypractisedemo.ui.main.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.main.present.HomeFragmentPresent;
import com.klivitam.mypractisedemo.ui.news.act.HomeLabelChannelActivity;
import com.klivitam.mypractisedemo.ui.news.frag.HomeNewsFragment;
import com.klivitam.mypractisedemo.utils.TabUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_ID;
import static com.klivitam.mypractisedemo.utils.AppConfig.FRAGMENT_TYPE;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragment extends BaseFragment<IHomeContract.Present> implements IHomeContract.View {
    private String TAG = "SD";
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.add_channel_iv)
    ImageView addChannelIv;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    private BaseFragmentAdapter adapter;

    private boolean isAddChannel = false;
    private int curFragment=1;
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        Log.i("klivitam", "initEventandDatas: ");

    }

    @OnClick({R.id.fab})
    public void onBottomClick(View view) {

    }

    @OnClick({R.id.add_channel_iv})
    public void addChannel(View view) {
        isAddChannel = true;
        startActivity(new Intent(getActivity(), HomeLabelChannelActivity.class));
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
    public void initTab(List<String> tab_datas,List<NewChannelBean> list1) {
        if (tab_datas == null||viewPager==null) {
            return;
        }
        adapter = new BaseFragmentAdapter(getChildFragmentManager(), getFragmentList(tab_datas.size(),list1), tab_datas);
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

    private List<Fragment> getFragmentList(int size,List<NewChannelBean> list1) {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Fragment f = new HomeNewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FRAGMENT_ID,list1.get(i).getChannelId());
            bundle.putString(FRAGMENT_TYPE,list1.get(i).getChannelType());
            f.setArguments(bundle);
            list.add(f);
        }
        return list;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isAddChannel){
            isAddChannel = false;
            getPresenter().start();
        }
    }
}
