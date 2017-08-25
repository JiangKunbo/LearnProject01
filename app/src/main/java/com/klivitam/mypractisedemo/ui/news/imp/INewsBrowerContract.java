package com.klivitam.mypractisedemo.ui.news.imp;

import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.NewsDetail;

import io.reactivex.Observable;

/**
 * Created by klivitam on 17-8-25.
 */

public interface INewsBrowerContract {
    interface View extends IContract.IView{
        String getPostId();
        void setWebView(String s);

    }
    interface Present extends IContract.IPresent<View>{

    }
    interface Model extends IContract.IModel{
        Observable<NewsDetail> getOnesDatas(String postId);

    }
}
