package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;

import com.jiangkunbo.common.rxbase.RxSchedulers;
import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.GrilDatas;
import com.klivitam.mypractisedemo.bean.PhotoGirl;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.present.BeautiFragmentPresent;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by klivitam on 17-8-11.
 */

public class BeautiFragmentModel implements IBeautiContract.Model {
    private Context context;
    private BeautiFragmentPresent present;

    public BeautiFragmentModel(Context context, BeautiFragmentPresent present) {
        this.context = context;
        this.present = present;
    }

    @Override
    public Observable<List<PhotoGirl>> getPhotosListData(int size, int page) {
        return Api.getDefault(HostType.GANK_GIRL_PHOTO)
                .getPhotoList(Api.getCacheControl(),size, page)
                .map(new Func1<GrilDatas, List<PhotoGirl>>() {
                    @Override
                    public List<PhotoGirl> call(GrilDatas girlData) {
                        return girlData.getResults();
                    }
                })
                .compose(RxSchedulers.<List<PhotoGirl>>io_main());
    }
}
