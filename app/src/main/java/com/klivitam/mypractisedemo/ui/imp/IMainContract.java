package com.klivitam.mypractisedemo.ui.imp;


import com.jiangkunbo.common.base.imp.IContract;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IMainContract {
    interface View extends IContract.IView{

    }
    interface Model extends IContract.IModel{

    }
    interface Present extends IContract.IPresent<View>{

    }
}
