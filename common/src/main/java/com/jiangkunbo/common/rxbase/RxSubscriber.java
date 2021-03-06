//package com.jiangkunbo.common.rxbase;
//
//import android.app.Activity;
//import android.content.Context;
//
//
//import com.jiangkunbo.common.R;
//import com.jiangkunbo.common.base.BaseApplication;
//import com.jiangkunbo.common.utills.NetWorkUtils;
//import com.jiangkunbo.common.widgets.LoadingDialog;
//
//import rx.Subscriber;
//
///**
// * des:订阅封装
// * Created by xsf
// * on 2016.09.10:16
// */
//
///********************使用例子********************/
///*_apiService.login(mobile, verifyCode)
//        .//省略
//        .subscribe(new RxSubscriber<User user>(mContext,false) {
//@Override
//public void _onNext(User user) {
//        // 处理user
//        }
//
//@Override
//public void _onError(String msg) {
//        ToastUtil.showShort(mActivity, msg);
//        });*/
//public abstract class RxSubscriber<T> extends Subscriber<T> {
//
//    private Context mContext;
//    private String msg;
//    private boolean showDialog=true;
//
//    /**
//     * 是否显示浮动dialog
//     */
//    public void showDialog() {
//        this.showDialog= true;
//    }
//    public void hideDialog() {
//        this.showDialog= true;
//    }
//
//    public RxSubscriber(Context context, String msg, boolean showDialog) {
//        this.mContext = context;
//        this.msg = msg;
//        this.showDialog=showDialog;
//    }
//    public RxSubscriber(Context context) {
//        this(context, BaseApplication.getInstance().getString(R.string.loading),true);
//    }
//    public RxSubscriber(Context context, boolean showDialog) {
//        this(context, BaseApplication.getInstance().getString(R.string.loading),showDialog);
//    }
//
//    @Override
//    public void onCompleted() {
//        if (showDialog)
//            LoadingDialog.cancelDialogForLoading();
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (showDialog) {
//            try {
//                LoadingDialog.showDialogForLoading((Activity) mContext,msg,true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @Override
//    public void onNext(T t) {
//        _onNext(t);
//    }
//    @Override
//    public void onError(Throwable e) {
//        if (showDialog)
//            LoadingDialog.cancelDialogForLoading();
//        e.printStackTrace();
//        //网络
//        if (!NetWorkUtils.isNetConnected(BaseApplication.getInstance())) {
//            _onError(BaseApplication.getInstance().getString(R.string.no_net));
//        }
//        //服务器
//        else if (e instanceof ServerException) {
//            _onError(e.getMessage());
//        }
//        //其它
//        else {
//            _onError(BaseApplication.getInstance().getString(R.string.net_error));
//        }
//    }
//
//    protected abstract void _onNext(T t);
//
//    protected abstract void _onError(String message);
//
//}
