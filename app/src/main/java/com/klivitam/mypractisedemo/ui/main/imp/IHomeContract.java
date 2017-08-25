package com.klivitam.mypractisedemo.ui.main.imp;


import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.NewChannelBean;
import com.klivitam.mypractisedemo.bean.NewsContentBean;

import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IHomeContract {
    interface View extends IContract.IView{
        void initTab(List<String> tab_datas,List<NewChannelBean> list1);

    }
    interface Model extends IContract.IModel{
        List<NewChannelBean> loadTabList();

    }
    interface Present extends IContract.IPresent<View>{

    }
}
