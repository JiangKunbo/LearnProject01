package com.jiangkunbo.common.rxjava.rxbus;

import android.app.Activity;
import android.content.Context;

import com.jiangkunbo.common.R;
import com.jiangkunbo.common.base.BaseApplication;
import com.jiangkunbo.common.utills.NetWorkUtils;
import com.jiangkunbo.common.widgets.LoadingDialog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by klivitam on 17-8-18.
 */

public abstract class RxSubscriber<T> implements Subscriber<T> {
    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context) {
        this(context, BaseApplication.getInstance().getString(R.string.loading), true);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getInstance().getString(R.string.loading), showDialog);
    }

    @Override
    public void onSubscribe(Subscription s) {
        if (showDialog) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onComplete() {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getInstance())) {
            _onError(BaseApplication.getInstance().getString(R.string.no_net));
        }
        //其它
        else {
            _onError(BaseApplication.getInstance().getString(R.string.net_error));
        }
    }


    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}
