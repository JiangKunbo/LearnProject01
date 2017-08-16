package com.klivitam.mypractisedemo.ui.main.present;

import android.content.Context;

import com.jiangkunbo.common.base.BasePresent;
import com.jiangkunbo.common.rxbase.RxSubscriber;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.PhotoGirl;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.model.BeautiFragmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public class BeautiFragmentPresent extends BasePresent<IBeautiContract.View,IBeautiContract.Model> implements IBeautiContract.Present{
    private List<PhotoGirl> allPhotoGirls = new ArrayList<>();

    @Override
    public void start() {

    }

    @Override
    protected IBeautiContract.Model loadModels(BasePresent<IBeautiContract.View, IBeautiContract.Model> viewModelBasePresent, Context context) {
        return new BeautiFragmentModel(getContext(),this);
    }

    @Override
    public void getPhotoList(int size, final int page) {
        mRxManage.add(getModels().getPhotosListData(size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(getContext(),false) {
            @Override
            public void onStart() {
                super.onStart();
                getViews().showLoading(getContext().getString(R.string.loading));
            }
            @Override
            protected void _onNext(List<PhotoGirl> photoGirls) {
                if(page == 0){
                    allPhotoGirls =  photoGirls;
                }else{
                    allPhotoGirls.addAll(photoGirls);
                }
                getViews().returnPhotosListData(allPhotoGirls);
                getViews().stopLoading();
            }

            @Override
            protected void _onError(String message) {
                getViews().showErrorTip(message);
            }
        }));
    }
}
