package com.klivitam.mypractisedemo.ui.video.imp;

import com.jiangkunbo.common.base.imp.IContract;

/**
 * Created by klivitam on 17-8-28.
 */

public interface IVideosItemContract {
    interface View extends IContract.IView{

    }
    interface Model extends IContract.IModel{

    }
    interface Present extends IContract.IPresent<View>{

    }
}
