package com.klivitam.mypractisedemo.ui.news.present;

import android.content.Context;
import android.util.Log;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.bean.NewsDetail;
import com.klivitam.mypractisedemo.ui.news.imp.INewsDetailContract;
import com.klivitam.mypractisedemo.ui.news.model.NewsDetailModel;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by klivitam on 17-8-25.
 */

public class NewsDetailPresent extends BasePresent<INewsDetailContract.View, INewsDetailContract.Model> implements INewsDetailContract.Present {
    @Override
    public void start() {
        getModels().getOnesDatas(getViews().getPostId())
                .subscribe(new Observer<NewsDetail>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull NewsDetail newsDetail) {
                        Log.i("jkb", "onNext: " + newsDetail.getLink());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected INewsDetailContract.Model loadModels(BasePresent<INewsDetailContract.View, INewsDetailContract.Model> viewModelBasePresent, Context context) {
        return new NewsDetailModel();
    }
}
