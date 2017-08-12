package com.klivitam.mypractisedemo.ui.frag;

import android.os.Bundle;

import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.present.BeautiFragmentPresent;

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
