package com.klivitam.mypractisedemo.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.List;


/**
 * Created by klivitam on 17-8-11.
 */

public class MyNewsFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> mLists;

    public MyNewsFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> mLists) {
        super(fm);
        this.fragmentList = fragmentList;
        this.mLists = mLists;
        if (this.fragmentList != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.fragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            fm.executePendingTransactions();
        }
        notifyDataSetChanged();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return (null != mLists.get(position)) && (mLists.size() > 0) ? mLists.get(position) : "";
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
