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
        WaresHot.getMethod4(new Callback<WaresBean>() {
            @Override
            public void onResponse(Call<WaresBean> call, Response<WaresBean> response) {
                mTv.setText(response.body().getCopyright());
                Log.e(TAG, "onResponse: " + response.body().getCopyright());
            }

            @Override
            public void onFailure(Call<WaresBean> call, Throwable t) {

            }
        });

    }
}
