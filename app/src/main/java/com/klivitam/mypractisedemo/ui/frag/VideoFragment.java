package com.klivitam.mypractisedemo.ui.frag;

import android.os.Bundle;

import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.present.VideoFragmentPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class VideoFragment extends BaseFragment<IVideoContract.Present> implements IVideoContract.View {
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected IVideoContract.Present loadPresent() {
        return new VideoFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }
}
