package com.example.coco.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        RetrofitUtils.getInstance().getRetrofit(new Callback<WaresBean>() {
            @Override
            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                mTv.setText(response.body().getCopyright());
                Log.e(TAG, "onResponse: " + response.body().getCopyright());
            }

            @Override
            public void onFailure(Call<WaresBean> call, Throwable t) {

            }
        });
        RetrofitUtils.getInstance().getRetrofit2(new Callback<WaresBean>() {
            @Override
            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                mTv2.setText(response.body().getCopyright());
                Log.e(TAG, "onResponse: " + response.body().getCopyright());
            }

            @Override
            public void onFailure(Call<WaresBean> call, Throwable t) {

            }
        });
        RetrofitUtils.getInstance().getRetrofit3(new Callback<WaresBean>() {
            @Override
            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                mTv3.setText(response.body().getCopyright());
                Log.e(TAG, "onResponse: " + response.body().getCopyright());
            }

            @Override
            public void onFailure(Call<WaresBean> call, Throwable t) {

            }
        });
        RetrofitUtils.getInstance().getRetrofit4(new Callback<WaresBean>() {
            @Override
            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                mTv4.setText(response.body().getCopyright());
                Log.e(TAG, "onResponse: " + response.body().getCopyright());
            }

            @Override
            public void onFailure(Call<WaresBean> call, Throwable t) {

            }
        });
    }
}
