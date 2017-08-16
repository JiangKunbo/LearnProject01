package com.klivitam.mypractisedemo.ui.news.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.jiangkunbo.common.rxbase.RxSubscriber;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewsContentBean;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.news.model.HomeNewFragmentModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewsFragmentPresent extends BasePresent<IHomeNewsContract.View,IHomeNewsContract.Model> implements IHomeNewsContract.Present{

    List<NewsContentBean> allSummaries = new ArrayList<>();

    @Override
    public void start() {

    }

    @Override
    protected IHomeNewsContract.Model loadModels(BasePresent<IHomeNewsContract.View, IHomeNewsContract.Model> viewModelBasePresent, Context context) {
        return new HomeNewFragmentModel(this,getContext());
    }

    @Override
    public void getListForRequest(String type, String id, final int startPage) {
        mRxManage.add(getModels().loadNetWorkList(type,id,startPage).subscribe(new RxSubscriber<List<NewsContentBean>>(getContext(),false) {
            @Override
            public void onStart() {
                super.onStart();
                getViews().showLoading(getContext().getString(R.string.loading));
            }

            @Override
            protected void _onNext(List<NewsContentBean> newsSummaries) {
                if (startPage ==0){
                    allSummaries = newsSummaries;
                }else{
                    allSummaries.addAll(newsSummaries);
                }
                getViews().returnNewsListData(allSummaries);
                getViews().stopLoading();
            }

            @Override
            protected void _onError(String message) {
                getViews().showErrorTip(message);
            }
        }));
    }
}
