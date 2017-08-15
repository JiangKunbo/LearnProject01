package com.klivitam.mypractisedemo.ui.main.frag;

import android.os.Bundle;

import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.main.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.main.present.CareFragmentPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class CareFragment extends BaseFragment<ICareContract.Present> implements ICareContract.View {
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected ICareContract.Present loadPresent() {
        return new CareFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_care;
    }
}
