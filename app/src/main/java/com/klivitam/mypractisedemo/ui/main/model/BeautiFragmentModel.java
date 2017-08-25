package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;
import android.support.annotation.MainThread;
import android.util.Log;

//import com.jiangkunbo.common.rxbase.RxSchedulers;
import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.GrilDatas;
import com.klivitam.mypractisedemo.bean.PhotoGirl;
import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.present.BeautiFragmentPresent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

//import rx.Observable;
//import rx.functions.Func1;

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
                .map(new Function<GrilDatas, List<PhotoGirl>>() {
                    @Override
                    public List<PhotoGirl> apply(@NonNull GrilDatas grilDatas) throws Exception {
                        Log.i("", "apply: ");
                            return grilDatas.getResults();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

    }

//    @Override
//    public Observable<List<PhotoGirl>> getPhotosListData(int size, int page) {
//        return Api.getDefault(HostType.GANK_GIRL_PHOTO)
//                .getPhotoList(Api.getCacheControl(),size, page)
//                .map(new Func1<GrilDatas, List<PhotoGirl>>() {
//                    @Override
//                    public List<PhotoGirl> call(GrilDatas girlData) {
//                        return girlData.getResults();
//                    }
//                })
//                .compose(RxSchedulers.<List<PhotoGirl>>io_main());
//    }
}
