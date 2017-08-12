package com.klivitam.mypractisedemo.base;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klivitam.mypractisedemo.base.imp.IContract;

import butterknife.ButterKnife;

/**
 * Created by klivitam on 17-8-10.
 */

public abstract class BaseFragment<P extends IContract.IPresent> extends Fragment implements IContract.IView {
    private P presenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
        }
        ButterKnife.bind(this, view);
        initEventandDatas(savedInstanceState);
        if (presenter == null) {
            presenter = loadPresent();
            presenter.attachView(this, getActivity().getApplication());
            presenter.start();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    protected abstract void initEventandDatas(Bundle savedInstanceState);

    protected abstract P loadPresent();

    protected abstract int getLayoutId();

    public P getPresenter() {
        return presenter;
    }

    public void intentAct(Class<?> c ,boolean isFinshActivity){
        startActivity(new Intent(getActivity(),c));
        if(isFinshActivity){
            getActivity().finish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detchView();
        }
    }
}
