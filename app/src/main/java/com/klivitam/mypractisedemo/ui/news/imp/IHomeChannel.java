package com.klivitam.mypractisedemo.ui.news.imp;


import com.jiangkunbo.common.base.imp.IContract;

import java.util.List;

/**
 * Created by klivitam on 17-8-12.
 */

public interface IHomeChannel {
    interface View extends IContract.IView {
        void showSelectItem(List<String> list);

        void showMoreItem(List<String> list);
    }

    interface Model extends IContract.IModel {
        List<String> loadSelectItem();

        List<String> loadMoreItem();
    }

    interface Present extends IContract.IPresent<View> {


    }
}
