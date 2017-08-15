package com.klivitam.mypractisedemo.ui.main.frag;

import android.os.Bundle;

import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.present.BeautiFragmentPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class BeautiFragment extends BaseFragment<IBeautiContract.Present> implements IBeautiContract.View {
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected IBeautiContract.Present loadPresent() {
        return new BeautiFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_beauti;
    }
}
