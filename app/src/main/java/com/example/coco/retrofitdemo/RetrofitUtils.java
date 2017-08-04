package com.example.coco.retrofitdemo;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by coco on 2017/8/4.
 */

public class RetrofitUtils {
    //单例化操作
    private static RetrofitUtils utils = new RetrofitUtils();
    private static Retrofit retrofit;

    private RetrofitUtils(){

    }
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://112.124.22.238:8081/course_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
   public void getRetrofit(Callback<WaresBean> callback){
       RetrofitService service = retrofit.create(RetrofitService.class);
       Call<WaresBean> call = service.getRetrofit();
       call.enqueue(callback);
   }
    public void getRetrofit2(Callback<WaresBean> callback){
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<WaresBean> call = service.getRetrofit2("0","10");
        call.enqueue(callback);
    }
    public void getRetrofit3(Callback<WaresBean> callback){
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<WaresBean> call = service.getRetrofit3("wares");
        call.enqueue(callback);
    }
    public void getRetrofit4(Callback<WaresBean> callback){
        RetrofitService service = retrofit.create(RetrofitService.class);
        Map<String,String>map=new HashMap<>();
        map.put("curPage","0");
        map.put("pageSize","10");
        Call<WaresBean> call = service.getRetrofit4(map);
        call.enqueue(callback);
    }
   public static RetrofitUtils getInstance(){
       return utils;
   }
}
