package com.klivitam.mypractisedemo.ui.act;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.base.BaseActivity;
import com.klivitam.mypractisedemo.ui.adapter.ShowChannelListAdapter;
import com.klivitam.mypractisedemo.ui.imp.IHomeChannel;
import com.klivitam.mypractisedemo.ui.present.HomeChannelPresent;
import com.klivitam.mypractisedemo.wdiget.ItemDragHelperCallback;

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

    private ShowChannelListAdapter mSelectAdapter;
    private ShowChannelListAdapter mMoreAdapter;

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
    public void showSelectItem(List<String> list) {
        mSelectAdapter = new ShowChannelListAdapter();
        mSelectAdapter.setList(list);
        newsChannelMoreRv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        newsChannelMoreRv.setItemAnimator(new DefaultItemAnimator());
        newsChannelMoreRv.setAdapter(mSelectAdapter);
        ItemDragHelperCallback itemDragHelperCallback = new ItemDragHelperCallback(mSelectAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragHelperCallback);
        itemTouchHelper.attachToRecyclerView(newsChannelMoreRv);
        mSelectAdapter.setItemDragHelperCallback(itemDragHelperCallback);


    }

    @Override
    public void showMoreItem(List<String> list) {
        mMoreAdapter = new ShowChannelListAdapter();
        mMoreAdapter.setList(list);
        newsChannelMineRv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        newsChannelMineRv.setItemAnimator(new DefaultItemAnimator());
        newsChannelMineRv.setAdapter(mMoreAdapter);
        mMoreAdapter.setOnItemListener(new ShowChannelListAdapter.OnItemListener() {
            @Override
            public void OnItemClick(View view, int positopn) {
                mMoreAdapter.removeItem(positopn);
            }
        });
    }
}
