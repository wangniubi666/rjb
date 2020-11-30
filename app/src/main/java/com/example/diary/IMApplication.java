package com.example.diary;

import android.app.Application;
import android.content.Context;

import com.example.diary.model.Model;

public class IMApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Model.getInstance().init(this);
        //初始化全局上下文对象
        mContext=this;
    }
}
