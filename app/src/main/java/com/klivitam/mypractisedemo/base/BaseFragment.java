package com.klivitam.mypractisedemo.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        if (presenter == null) {
            presenter = loadPresent();
            presenter.attachView(this, getActivity().getApplication());
            presenter.start();
        }
        initEventandDatas();

        return view;
    }

    protected abstract void initEventandDatas();

    protected abstract P loadPresent();

    protected abstract int getLayoutId();

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detchView();
        }
    }
}
