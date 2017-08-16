package com.klivitam.mypractisedemo.ui.main.imp;


import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.PhotoGirl;

import java.util.List;

import rx.Observable;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IBeautiContract {
    interface View extends IContract.IView{
        void returnPhotosListData(List<PhotoGirl> photoGirls);
        void showLoading(String s);
        void showErrorTip(String s);
        void stopLoading();

    }
    interface Model extends IContract.IModel{
        Observable<List<PhotoGirl>> getPhotosListData(int size, int page);

    }
    interface Present extends IContract.IPresent<View>{
        void getPhotoList(int size,int page);

    }
}
