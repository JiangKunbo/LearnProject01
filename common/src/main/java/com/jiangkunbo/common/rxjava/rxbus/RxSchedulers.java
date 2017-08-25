package com.jiangkunbo.common.rxjava.rxbus;

import android.widget.Toast;

import com.jiangkunbo.common.R;
import com.jiangkunbo.common.base.BaseActivity;
import com.jiangkunbo.common.base.BaseApplication;
import com.jiangkunbo.common.utills.NetWorkUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by klivitam on 17-8-18.
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                if (!NetWorkUtils.isNetConnected(BaseApplication.getInstance())) {
                                    Toast.makeText(BaseApplication.getInstance(), R.string.no_net, Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
