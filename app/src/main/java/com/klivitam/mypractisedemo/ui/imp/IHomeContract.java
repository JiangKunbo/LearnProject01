package com.klivitam.mypractisedemo.ui.imp;

import com.klivitam.mypractisedemo.base.imp.IContract;

import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IHomeContract {
    interface View extends IContract.IView{
        void initTab(List<String> tab_datas);

    }
    interface Model extends IContract.IModel{
        List<String> loadTabList();

    }
    interface Present extends IContract.IPresent<View>{

    }
}
