package com.klivitam.mypractisedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;


import com.jiangkunbo.common.base.BaseActivity;
import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.ui.frag.BeautiFragment;
import com.klivitam.mypractisedemo.ui.frag.CareFragment;
import com.klivitam.mypractisedemo.ui.frag.HomeFragment;
import com.klivitam.mypractisedemo.ui.frag.VideoFragment;
import com.klivitam.mypractisedemo.ui.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.present.MainActivityPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.klivitam.mypractisedemo.contact.AppConfig.BEAUTI_FRAGMENT;
import static com.klivitam.mypractisedemo.contact.AppConfig.CARE_FRAGMENT;
import static com.klivitam.mypractisedemo.contact.AppConfig.HOME_FRAGMENT;
import static com.klivitam.mypractisedemo.contact.AppConfig.VIDEO_FRAGMENT;


public class MainActivity extends BaseActivity<IMainContract.Present> implements IMainContract.View {
    private String TAG = "JKB";
    @BindView(R.id.tab_view)
    BottomNavigationView mTabView;

    private HomeFragment homeFragment;
    private BeautiFragment beautiFragment;
    private VideoFragment videoFragment;
    private CareFragment careFragment;
    private List<BaseFragment> mList;

    private int curWinM = -1;


    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        initFragment();
        mTabView.setOnNavigationItemSelectedListener(litener);
        mTabView.setOnNavigationItemReselectedListener(reListener);
    }

    /**
     * 初次调用
     */
    private BottomNavigationView.OnNavigationItemSelectedListener litener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.tab_home:
                    switchFragment(curWinM, HOME_FRAGMENT);
                    return true;
                case R.id.tab_beauti:
                    switchFragment(curWinM, BEAUTI_FRAGMENT);
                    return true;
                case R.id.tab_video:
                    switchFragment(curWinM, VIDEO_FRAGMENT);
                    return true;
                case R.id.tab_care:
                    switchFragment(curWinM, CARE_FRAGMENT);
                    return true;
            }
            return false;
        }
    };
    /**
     * 重复调用
     */
    private BottomNavigationView.OnNavigationItemReselectedListener reListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Log.i("klivitam", "onNavigationItemReselected: ");

        }
    };

    private void switchFragment(int curWin, int newWin) {
        Log.i(TAG, "switchFragment: "+newWin);
        if (curWin == newWin) {
            return;
        }
        curWinM = newWin;
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.hide(mList.get(curWin));
        if (!mList.get(newWin).isAdded()) {
            ft.add(R.id.main_content, mList.get(newWin));
        }
        ft.show(mList.get(newWin)).commitAllowingStateLoss();
    }

    private void initFragment() {
        mList = new ArrayList<>();
        homeFragment = new HomeFragment();
        beautiFragment = new BeautiFragment();
        videoFragment = new VideoFragment();
        careFragment = new CareFragment();
        mList.add(homeFragment);
        mList.add(beautiFragment);
        mList.add(videoFragment);
        mList.add(careFragment);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, homeFragment)
                .show(homeFragment)
                .commit();
        curWinM = HOME_FRAGMENT;
    }

    @Override
    protected MainActivityPresent loadPresent() {
        return new MainActivityPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
