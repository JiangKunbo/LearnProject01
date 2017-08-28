package com.klivitam.mypractisedemo.ui.main.imp;


import com.jiangkunbo.common.base.imp.IContract;
import com.klivitam.mypractisedemo.bean.VideoChannelTable;

import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public interface IVideoContract {
    interface View extends IContract.IView{
        void initViews(List<VideoChannelTable> videoChannelTableList);

    }
    interface Model extends IContract.IModel{
        List<VideoChannelTable> loadVideosChannelsMine();
    }
    interface Present extends IContract.IPresent<View>{

    }
}
