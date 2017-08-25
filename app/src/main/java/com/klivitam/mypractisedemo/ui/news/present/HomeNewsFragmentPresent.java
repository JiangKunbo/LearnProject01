package com.klivitam.mypractisedemo.ui.news.present;

import android.content.Context;
import android.util.Log;

import com.jiangkunbo.common.base.BasePresent;
import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.NewsContentBean;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.news.model.HomeNewFragmentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragmentPresent extends BasePresent<IHomeNewsContract.View, IHomeNewsContract.Model> implements IHomeNewsContract.Present {

    List<NewsContentBean> allSummaries = new ArrayList<>();

    @Override
    public void start() {

    }

    @Override
    protected IHomeNewsContract.Model loadModels(BasePresent<IHomeNewsContract.View, IHomeNewsContract.Model> viewModelBasePresent, Context context) {
        return new HomeNewFragmentModel(this, getContext());
    }

    @Override
    public void getListForRequest(String type, String id, final int startPage) {
        getModels().loadNetWorkList(type, id, 0)
                .subscribe(new Observer<List<NewsContentBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        getViews().showLoading("start...");
                    }

                    @Override
                    public void onNext(@NonNull List<NewsContentBean> newsContentBeen) {
                        Log.i("", "onNext: ");
                        if (startPage == 0) {
                            allSummaries = newsContentBeen;
                        } else {
                            allSummaries.addAll(newsContentBeen);
                        }
                        getViews().returnNewsListData(allSummaries);
                        getViews().stopLoading();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getViews().showErrorTip(""+e);
                        Log.i("jkb", "onError: "+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        mRxManage.add(getModels().loadNetWorkList(type,id,startPage).subscribe(new RxSubscriber<List<NewsContentBean>>(getContext(),false) {
//            @Override
//            public void onStart() {
//                super.onStart();
//                getViews().showLoading(getContext().getString(R.string.loading));
//            }
//
//            @Override
//            protected void _onNext(List<NewsContentBean> newsSummaries) {
//                if (startPage ==0){
//                    allSummaries = newsSummaries;
//                }else{
//                    allSummaries.addAll(newsSummaries);
//                }
//                getViews().returnNewsListData(allSummaries);
//                getViews().stopLoading();
//            }
//
//            @Override
//            protected void _onError(String message) {
//                getViews().showErrorTip(message);
//            }
//        }));
    }
}
