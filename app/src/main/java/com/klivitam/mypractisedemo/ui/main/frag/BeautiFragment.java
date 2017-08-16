package com.klivitam.mypractisedemo.ui.main.frag;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiangkunbo.common.base.BaseFragment;
import com.jiangkunbo.common.recylerview.CommonRecycleViewAdapter;
import com.jiangkunbo.common.recylerview.ViewHolderHelper;
import com.jiangkunbo.common.widgets.LoadingTip;
import com.jiangkunbo.common.widgets.NormalTitleBar;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.PhotoGirl;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.present.BeautiFragmentPresent;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by klivitam on 17-8-10.
 */

public class BeautiFragment extends BaseFragment<IBeautiContract.Present> implements IBeautiContract.View {
    @BindView(R.id.refresh_layout_beauti)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.list_beauti)
    RecyclerView mRecyclerView;
    @BindView(R.id.ntb)
    NormalTitleBar ntb;
    @BindView(R.id.loadedTip)
    LoadingTip loadingTip;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private int page = 0;
    private int SIZE = 20;


    private CommonRecycleViewAdapter<PhotoGirl> adapter;
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        ntb.setTvLeftVisiable(false);
        ntb.setTitleText(getString(R.string.girl_title));
        adapter=new CommonRecycleViewAdapter<PhotoGirl>(getContext(),R.layout.item_photo) {
            @Override
            public void convert(ViewHolderHelper helper, final PhotoGirl photoGirl) {
                ImageView imageView=helper.getView(R.id.iv_photo);
                Glide.with(mContext).load(photoGirl.getUrl())
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.drawable.ic_image_loading)
                        .error(R.drawable.ic_empty_picture)
                        .centerCrop().override(1090, 1090*3/4)
                        .crossFade().into(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        PhotosDetailActivity.startAction(mContext,photoGirl.getUrl());
                    }
                });
            }
        };
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getPresenter().getPhotoList(SIZE,page);
                mRefreshLayout.finishLoadmore();

            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 0;
                getPresenter().getPhotoList(SIZE,page);
                mRefreshLayout.finishRefresh();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });
        getPresenter().getPhotoList(SIZE,page);
    }

    @Override
    protected IBeautiContract.Present loadPresent() {
        return new BeautiFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_beauti;
    }

    @Override
    public void returnPhotosListData(List<PhotoGirl> photoGirls) {
        adapter.replaceAll(photoGirls);
    }

    @Override
    public void showLoading(String s) {

    }

    @Override
    public void showErrorTip(String s) {

    }

    @Override
    public void stopLoading() {

    }
}
