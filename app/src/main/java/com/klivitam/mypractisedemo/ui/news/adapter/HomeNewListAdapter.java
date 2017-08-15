package com.klivitam.mypractisedemo.ui.news.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.jiangkunbo.common.recylerview.MultiItemRecycleViewAdapter;
import com.jiangkunbo.common.recylerview.MultiItemTypeSupport;
import com.jiangkunbo.common.recylerview.ViewHolderHelper;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewsContentBean;

import java.util.List;

import static com.klivitam.mypractisedemo.contact.AppConfig.TYPE_ITEM;
import static com.klivitam.mypractisedemo.contact.AppConfig.TYPE_PHOTO_ITEM;

/**
 * Created by klivitam on 17-8-12.
 */

public class HomeNewListAdapter extends MultiItemRecycleViewAdapter<NewsContentBean> {
    public HomeNewListAdapter(Context context, final List<NewsContentBean> datas) {
        super(context, datas, new MultiItemTypeSupport<NewsContentBean>() {

            @Override
            public int getLayoutId(int type) {
                if (type == TYPE_PHOTO_ITEM) {
                    return R.layout.item_news_photo;
                } else {
                    return R.layout.item_news;
                }
            }

            @Override
            public int getItemViewType(int position, NewsContentBean msg) {
                if (!TextUtils.isEmpty(msg.getDigest())) {
                    return TYPE_ITEM;
                }
                return TYPE_PHOTO_ITEM;
            }
        });
    }
    @Override
    public void convert(ViewHolderHelper helper, NewsContentBean newsContentBean) {
        switch (helper.getLayoutId())
        {
            case R.layout.item_news:
//                setItemValues(holder,newsSummary,getPosition(holder));
                break;
            case R.layout.item_news_photo:
//                setPhotoItemValues(holder,newsSummary,getPosition(holder));
                break;
        }
    }
}
