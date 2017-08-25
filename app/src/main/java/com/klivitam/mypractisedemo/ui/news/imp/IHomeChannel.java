package com.klivitam.mypractisedemo.ui.news.imp;


import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.NewChannelBean;

import java.util.List;

/**
 * Created by klivitam on 17-8-12.
 */

public interface IHomeChannel {
    interface View extends IContract.IView {
        void showSelectItem(List<NewChannelBean> list);

        void showMoreItem(List<NewChannelBean> list);
    }

    interface Model extends IContract.IModel {
        List<NewChannelBean> loadSelectItem();

        List<NewChannelBean> loadMoreItem();
    }

    interface Present extends IContract.IPresent<View> {


    }
}
