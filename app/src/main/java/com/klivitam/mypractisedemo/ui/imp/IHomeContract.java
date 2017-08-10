package com.klivitam.mypractisedemo.ui.imp;

import com.klivitam.mypractisedemo.base.imp.IContract;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IHomeContract {
    interface View extends IContract.IView{

    }
    interface Model extends IContract.IModel{

    }
    interface Present extends IContract.IPresent<View>{

    }
}
