package com.klivitam.mypractisedemo.ui.news.act;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;

import com.jiangkunbo.common.base.BaseActivity;
import com.jiangkunbo.common.recylerview.ItemDragHelperCallback;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.news.adapter.ShowChannelAdapter;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeChannel;
import com.klivitam.mypractisedemo.ui.news.present.HomeChannelPresent;


import java.util.List;

import butterknife.BindView;

/**
 * Created by klivitam on 17-8-12.
 */

public class HomeLabelChannelActivity extends BaseActivity<IHomeChannel.Present> implements IHomeChannel.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.news_channel_mine_rv)
    RecyclerView newsChannelMineRv;
    @BindView(R.id.news_channel_more_rv)
    RecyclerView newsChannelMoreRv;

    private ShowChannelAdapter mSelectAdapter;
    private ShowChannelAdapter mMoreAdapter;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });

    }

    @Override
    protected IHomeChannel.Present loadPresent() {
        return new HomeChannelPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_channel;
    }

    @Override
    public void showSelectItem(final List<String> list) {
        Log.i("jkb", "showSelectItem: "+list.size());
        mSelectAdapter = new ShowChannelAdapter(getApplication(),R.layout.item_list_channel);
        newsChannelMineRv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        newsChannelMineRv.setItemAnimator(new DefaultItemAnimator());
        newsChannelMineRv.setAdapter(mSelectAdapter);
        mSelectAdapter.replaceAll(list);

        mSelectAdapter.setOnItemClickListener(new ShowChannelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mMoreAdapter.add(mSelectAdapter.getAll().get(position));
                mSelectAdapter.removeAt(position);
            }
        });
        ItemDragHelperCallback itemDragHelperCallback = new ItemDragHelperCallback(mSelectAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragHelperCallback);
        itemTouchHelper.attachToRecyclerView(newsChannelMineRv);
        mSelectAdapter.setItemDragHelperCallback(itemDragHelperCallback);
    }

    @Override
    public void showMoreItem(final List<String> list) {
        Log.i("jkb", "showMoreItem: "+list.size());
        mMoreAdapter = new ShowChannelAdapter(getApplication(),R.layout.item_list_channel);
        newsChannelMoreRv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        newsChannelMoreRv.setItemAnimator(new DefaultItemAnimator());
        mMoreAdapter.replaceAll(list);
        newsChannelMoreRv.setAdapter(mMoreAdapter);
        mMoreAdapter.setOnItemClickListener(new ShowChannelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mSelectAdapter.add(mMoreAdapter.getAll().get(position));
                mMoreAdapter.removeAt(position);
            }
        });
    }
}