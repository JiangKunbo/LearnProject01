package com.klivitam.mypractisedemo.ui.news.model;

import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.NewsDetail;
import com.klivitam.mypractisedemo.ui.news.imp.INewsBrowerContract;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by klivitam on 17-8-25.
 */

public class NewsBrowserModel implements INewsBrowerContract.Model {
    @Override
    public Observable<NewsDetail> getOnesDatas(final String postId) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewDetail(Api.getCacheControl(),postId)
                .map(new Function<Map<String, NewsDetail>, NewsDetail>() {
                    @Override
                    public NewsDetail apply(@NonNull Map<String, NewsDetail> stringNewsDetailMap) throws Exception {
                        NewsDetail newsDetail = stringNewsDetailMap.get(postId);
                        changeNewsDetail(newsDetail);
                        return newsDetail;
                    }
                }).distinct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
    private void changeNewsDetail(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getBody();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setBody(newsBody);
        }
    }
    private boolean isChange(List<NewsDetail.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetail.ImgBean> imgSrcs, String newsBody) {
        for (int i = 0; i < imgSrcs.size(); i++) {
            String oldChars = "<!--IMG#" + i + "-->";
            String newChars;
            if (i == 0) {
                newChars = "";
            } else {
                newChars = "<img src=\"" + imgSrcs.get(i).getSrc() + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}
