package com.example.coco.retrofitdemo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by coco on 2017/8/3.
 */

public interface RetrofitService {
    @GET("wares/hot?curPage=0&pageSize=10")
    Call<WaresBean> getRetrofit();
    @GET("wares/hot")
    Call<WaresBean> getRetrofit2(@Query("curPage") String curPage,@Query("pageSize") String pageSize);
    @GET("{type}/hot?curPage=0&pageSize=10")
    Call<WaresBean> getRetrofit3(@Path("type")String type);
    @GET("wares/hot")
    Call<WaresBean> getRetrofit4(@QueryMap()Map<String,String> map);
    @GET("wares/hot?curPage=0&pageSize=10")
    Observable<WaresBean>getRetrofit5();
}
