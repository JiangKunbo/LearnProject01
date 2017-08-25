package com.klivitam.mypractisedemo.ui.news.model;

import android.content.Context;

import com.klivitam.mypractisedemo.api.Api;
import com.klivitam.mypractisedemo.api.HostType;
import com.klivitam.mypractisedemo.bean.NewsContentBean;
import com.klivitam.mypractisedemo.ui.news.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.news.present.HomeNewsFragmentPresent;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewFragmentModel implements IHomeNewsContract.Model {
    private Context context;
    private HomeNewsFragmentPresent present;

    public HomeNewFragmentModel(HomeNewsFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }

    @Override
    public Observable<List<NewsContentBean>> loadNetWorkList(String type, final String id, int startPage) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewsList(Api.getCacheControl(),type, id, startPage)
                .flatMap(new Function<Map<String, List<NewsContentBean>>, Observable<List<NewsContentBean>>>() {
                    @Override
                    public Observable<List<NewsContentBean>> apply(@NonNull Map<String, List<NewsContentBean>> stringListMap) throws Exception {
                        return Observable.just(stringListMap.get(id));
                    }
                })
                .distinct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }


//    @Override
//    public Observable<List<NewsContentBean>> loadNetWorkList(String type, final String id, int startPage) {
//        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewsList(Api.getCacheControl(),type, id, startPage)
//                .flatMap(new Func1<Map<String, List<NewsContentBean>>, Observable<NewsContentBean>>() {
//                    @Override
//                    public Observable<NewsContentBean> call(Map<String, List<NewsContentBean>> map) {
//                        return Observable.from(map.get(id));
//                    }
//                })
//                //转化时间
//                .map(new Func1<NewsContentBean, NewsContentBean>() {
//                    @Override
//                    public NewsContentBean call(NewsContentBean newsSummary) {
//                        String ptime = TimeUtil.formatDate(newsSummary.getPtime());
//                        newsSummary.setPtime(ptime);
//                        return newsSummary;
//                    }
//                })
//                .distinct()//去重
//                .toSortedList(new Func2<NewsContentBean, NewsContentBean, Integer>() {
//                    @Override
//                    public Integer call(NewsContentBean newsSummary, NewsContentBean newsSummary2) {
//                        return newsSummary2.getPtime().compareTo(newsSummary.getPtime());
//                    }
//                })
//                //声明线程调度
//                .compose(RxSchedulers.<List<NewsContentBean>>io_main());
//
//    }
}
