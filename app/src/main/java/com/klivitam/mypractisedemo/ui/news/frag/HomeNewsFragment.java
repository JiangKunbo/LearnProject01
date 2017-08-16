package com.klivitam.mypractisedemo.ui.news.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.jiangkunbo.animation.ScaleInAnimation;
import com.jiangkunbo.common.base.BaseFragment;
import com.jiangkunbo.common.recylerview.OnItemClickListener;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewsContentBean;
import com.klivitam.mypractisedemo.ui.news.adapter.HomeNewListAdapter;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.news.present.HomeNewsFragmentPresent;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragment extends BaseFragment<IHomeNewsContract.Present> implements IHomeNewsContract.View {
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.list_news)
    RecyclerView mRecyclerView;

    private String mNewsId;
    private String mNewsType;
    private int mStartPage=0;

    private List<NewsContentBean> datas;
    private HomeNewListAdapter adapter;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        initRefreshLogic();
    }

//    http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
    private void initRefreshLogic() {
//        if(getArguments()!=null){
        mNewsId = "T1348647909107";
        mNewsType = "headline";
//        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        datas = new ArrayList<>();
        adapter = new HomeNewListAdapter(getContext(),datas);
        adapter.openLoadAnimation(new ScaleInAnimation());
        mRecyclerView.setAdapter(adapter);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableAutoLoadmore(true);
        mRefreshLayout.setRefreshHeader(new DeliveryHeader(getContext()));
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mStartPage = 0;
                getPresenter().getListForRequest(mNewsType,mNewsId,mStartPage);
                mRefreshLayout.finishRefresh();
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mStartPage+=20;
                getPresenter().getListForRequest(mNewsType,mNewsId,mStartPage);
                mRefreshLayout.finishLoadmore();

            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                Bundle bundle = new Bundle();

            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
        if(adapter.getSize()<=0){
            getPresenter().getListForRequest(mNewsType,mNewsId,mStartPage);
        }
    }

    @Override
    protected HomeNewsFragmentPresent loadPresent() {
        return new HomeNewsFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_new;
    }

    @Override
    public void showLoading(String s) {

    }

    @Override
    public void returnNewsListData(List<NewsContentBean> list) {
        if(list!=null){
            adapter.replaceAll(list);
        }
    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String message) {

    }
}
