package com.klivitam.mypractisedemo.ui.frag;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.jiangkunbo.common.base.BaseFragment;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.present.HomeNewsFragmentPresent;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragment extends BaseFragment<IHomeNewsContract.Present> implements IHomeNewsContract.View {
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.list_news)
    RecyclerView mRecyclerView;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        initRefreshLogic();
    }

    private void initRefreshLogic() {
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableAutoLoadmore(true);
        mRefreshLayout.setRefreshHeader(new DeliveryHeader(getContext()));
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }
        });
    }

    @Override
    protected HomeNewsFragmentPresent loadPresent() {
        return new HomeNewsFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_new;
    }
}
