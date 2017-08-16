package com.example.coco.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "===";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mTv = (TextView) findViewById(R.id.mTv);
        final TextView mTv2 = (TextView) findViewById(R.id.mTv2);
        final TextView mTv3 = (TextView) findViewById(R.id.mTv3);
        final TextView mTv4 = (TextView) findViewById(R.id.mTv4);

        initRxJava3();
//        WaresHot.getMethod4(new Callback<WaresBean>() {
//            @Override
//            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
//                mTv.setText(response.body().getCopyright());
//                Log.e(TAG, "onResponse: " + response.body().getCopyright());
//            }
//
//            @Override
//            public void onFailure(Call<WaresBean> call, Throwable t) {
//
//            }
//        });
//        RetrofitUtils.getInstance().getRetrofit(new Callback<WaresBean>() {
//            @Override
//            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
//                mTv.setText(response.body().getCopyright());
//                Log.e(TAG, "onResponse: " + response.body().getCopyright());
//            }
//
//            @Override
//            public void onFailure(Call<WaresBean> call, Throwable t) {
//
//            }
//        });
//        RetrofitUtils.getInstance().getRetrofit2(new Callback<WaresBean>() {
//            @Override
//            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
//                mTv2.setText(response.body().getCopyright());
//                Log.e(TAG, "onResponse: " + response.body().getCopyright());
//            }
//
//            @Override
//            public void onFailure(Call<WaresBean> call, Throwable t) {
//
//            }
//        });
//        RetrofitUtils.getInstance().getRetrofit3(new Callback<WaresBean>() {
//            @Override
//            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
//                mTv3.setText(response.body().getCopyright());
//                Log.e(TAG, "onResponse: " + response.body().getCopyright());
//            }
//
//            @Override
//            public void onFailure(Call<WaresBean> call, Throwable t) {
//
//            }
//        });
//        RetrofitUtils.getInstance().getRetrofit4(new Callback<WaresBean>() {
//            @Override
//            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
//                mTv4.setText(response.body().getCopyright());
//                Log.e(TAG, "onResponse: " + response.body().getCopyright());
//            }
//
//            @Override
//            public void onFailure(Call<WaresBean> call, Throwable t) {
//
//            }
//        });
    }

    private void initRxJava3() {
        RxjavaHelper.getInstance().getHelper(new MyTask() {
            @Override
            public void run() {
                Log.e(TAG, "run: "+getBean().getCopyright() );
            }
        });

    }

    private void initRxJava2() {
        Observable<WaresBean> observable = Observable.create(new Observable.OnSubscribe<WaresBean>() {
            @Override
            public void call(final Subscriber<? super WaresBean> subscriber) {
             runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     RetrofitUtils.getInstance().getRetrofit(new Callback<WaresBean>() {
                         @Override
                         public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                             WaresBean s = response.body();
                             subscriber.onNext(s);
                         }

                         @Override
                         public void onFailure(Call<WaresBean> call, Throwable t) {

                         }
                     });
                 }
             });
            }
        });
        Observer<WaresBean> observer = new Observer<WaresBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WaresBean s) {
                Log.e(TAG, "onNext: "+s.getCopyright());
            }
        };
        observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(observer);
    }

    private void initRxJava() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("aaaa");
                subscriber.onNext("bbbb");
                subscriber.onNext("cccc");
                subscriber.onCompleted();
            }
        });
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: "+s);
            }
        };
        observable.subscribe(observer);

    }
}
