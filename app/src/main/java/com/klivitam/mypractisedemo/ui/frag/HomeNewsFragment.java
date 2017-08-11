package com.klivitam.mypractisedemo.ui.frag;

import android.os.Bundle;

import com.klivitam.mypractisedemo.base.BaseFragment;
import com.klivitam.mypractisedemo.ui.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.present.HomeNewsFragmentPresent;

/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragment extends BaseFragment<IHomeNewsContract.Present> implements IHomeNewsContract.View{
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected HomeNewsFragmentPresent loadPresent() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
