package com.klivitam.mypractisedemo.ui.news.model;

import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.NewsDetail;
import com.klivitam.mypractisedemo.ui.news.imp.INewsDetailContract;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by klivitam on 17-8-25.
 */

public class NewsDetailModel implements INewsDetailContract.Model {
    @Override
    public Observable<NewsDetail> getOnesDatas(String postId) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewDetail(Api.getCacheControl(),postId)
                .map(new Function<Map<String, NewsDetail>, NewsDetail>() {
                    @Override
                    public NewsDetail apply(@NonNull Map<String, NewsDetail> stringNewsDetailMap) throws Exception {
                        return null;
                    }
                }).distinct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
