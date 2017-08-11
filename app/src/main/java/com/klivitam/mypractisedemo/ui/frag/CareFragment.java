package com.klivitam.mypractisedemo.ui.frag;

import android.os.Bundle;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.base.BaseFragment;
import com.klivitam.mypractisedemo.ui.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.present.CareFragmentPresent;

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
