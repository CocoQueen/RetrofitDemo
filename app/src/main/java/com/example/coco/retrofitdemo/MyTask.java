package com.example.coco.retrofitdemo;

/**
 * Created by coco on 2017/8/7.
 */

public abstract class MyTask implements Runnable {
    public WaresBean getBean() {
        return bean;
    }

    public void setBean(WaresBean bean) {
        this.bean = bean;
    }

    private WaresBean bean;
}
