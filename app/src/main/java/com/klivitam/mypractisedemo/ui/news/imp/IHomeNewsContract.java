package com.klivitam.mypractisedemo.ui.news.imp;


import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.bean.NewsContentBean;

import java.util.List;

import rx.Observable;


/**
 * Created by klivitam on 17-8-11.
 */

public interface IHomeNewsContract {

    interface View extends IContract.IView {
        void showLoading(String s);
        void returnNewsListData(List<NewsContentBean> list);
        void stopLoading();
        void showErrorTip(String message);

    }

    interface Model extends IContract.IModel {
        Observable<List<NewsContentBean>> loadNetWorkList(String type, String id, int startPage);

    }

    interface Present extends IContract.IPresent<View> {
        void getListForRequest(String type, String id, int startPage);

    }
}
