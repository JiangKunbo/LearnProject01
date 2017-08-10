package com.klivitam.mypractisedemo.ui.frag;

import com.klivitam.mypractisedemo.base.BaseFragment;
import com.klivitam.mypractisedemo.ui.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.present.HomePresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragment extends BaseFragment<IHomeContract.Present> implements IHomeContract.View {
    @Override
    protected void initEventandDatas() {

    }

    @Override
    protected IHomeContract.Present loadPresent() {
        return new HomePresent();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
