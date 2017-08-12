package com.jiangkunbo.common.base;

import android.content.Context;

import com.jiangkunbo.common.base.imp.IContract;


/**
 * Created by jiangkunbo on 17-8-10.
 */

public abstract class BasePresent<V extends IContract.IView, M extends IContract.IModel> implements IContract.IPresent<V> {
    private V views;
    private M models;
    private Context context;

    @Override
    public void attachView(V views, Context context) {
        this.views = views;
        this.context = context;
        models = loadModels(this, context);
    }

    @Override
    public void detchView() {
        views = null;
        models = null;
    }

    public V getViews() {
        return views;
    }

    public M getModels() {
        return models;
    }

    public Context getContext() {
        return context;
    }

    protected abstract M loadModels(BasePresent<V, M> vmBasePresent, Context context);
}
