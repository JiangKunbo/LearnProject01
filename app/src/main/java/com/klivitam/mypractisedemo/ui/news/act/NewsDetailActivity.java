package com.klivitam.mypractisedemo.ui.news.act;

import android.os.Bundle;

import com.jiangkunbo.common.base.BaseActivity;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.news.imp.INewsDetailContract;
import com.klivitam.mypractisedemo.ui.news.present.NewsDetailPresent;

import static com.klivitam.mypractisedemo.utils.AppConfig.NEWS_POST_ID;

/**
 * Created by klivitam on 17-8-16.
 */

public class NewsDetailActivity extends BaseActivity<INewsDetailContract.Present> implements INewsDetailContract.View{
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected INewsDetailContract.Present loadPresent() {
        return new NewsDetailPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail_web;
    }

    @Override
    public String getPostId() {
        return getIntent().getStringExtra(NEWS_POST_ID);
    }
}
