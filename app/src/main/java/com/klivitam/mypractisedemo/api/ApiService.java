package com.klivitam.mypractisedemo.api;

import com.klivitam.mypractisedemo.bean.GrilDatas;
import com.klivitam.mypractisedemo.bean.NewsContentBean;


import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by klivitam on 17-8-14.
 */

public interface ApiService {

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsContentBean>>> getNewsList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type, @Path("id") String id,
            @Path("startPage") int startPage);

    //    http://gank.io/api/data/福利/{size}/{page}
    @GET("data/福利/{size}/{page}")
    Observable<GrilDatas> getPhotoList(
            @Header("Cache-Control") String cacheControl,
            @Path("size") int size,
            @Path("page") int page);
}
