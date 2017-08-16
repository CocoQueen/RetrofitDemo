package com.example.coco.retrofitdemo;

import android.os.Handler;
import android.os.Looper;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by coco on 2017/8/7.
 */

public class RxjavaHelper {
    private static volatile RxjavaHelper helper;
    private Retrofit retrofit;
    private final RetrofitService service;

    private RxjavaHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://112.124.22.238:8081/course_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public static RxjavaHelper getInstance() {
        if (helper == null) {
            synchronized (RxjavaHelper.class) {
                if (helper == null) {
                    helper = new RxjavaHelper();
                }
            }
        }
        return helper;
    }

    public void getHelper(final MyTask runnable) {
        Observable<WaresBean> observable = service.getRetrofit5();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WaresBean>() {
                    @Override
                    public void call(WaresBean waresBean) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        runnable.setBean(waresBean);
                        handler.post(runnable);
                    }
                });

    }
}
