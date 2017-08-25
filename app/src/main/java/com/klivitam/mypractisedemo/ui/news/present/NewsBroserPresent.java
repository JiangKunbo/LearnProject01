package com.klivitam.mypractisedemo.ui.news.present;

import android.content.Context;
import android.util.Log;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.bean.NewsDetail;
import com.klivitam.mypractisedemo.ui.news.imp.INewsBrowerContract;
import com.klivitam.mypractisedemo.ui.news.imp.INewsDetailContract;
import com.klivitam.mypractisedemo.ui.news.model.NewsBrowserModel;
import com.klivitam.mypractisedemo.ui.news.model.NewsDetailModel;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by klivitam on 17-8-25.
 */

public class NewsBroserPresent extends BasePresent<INewsBrowerContract.View,INewsBrowerContract.Model> implements INewsBrowerContract.Present {

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
                        getViews().setWebView(newsDetail.getShareLink());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("jkb", "onError: ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    protected INewsBrowerContract.Model loadModels(BasePresent<INewsBrowerContract.View, INewsBrowerContract.Model> viewModelBasePresent, Context context) {
        return new NewsBrowserModel();
    }
}
