package com.example.diary.model;

import android.content.Context;

import com.example.diary.model.dao.DiaryTableDao;


//数据模型全局类
public class Model {
    private Context mContext;
    private static Model model=new Model();
    private DiaryTableDao diaryTableDao;

    private Model(){}

    public static Model getInstance(){return model;}

    public void init(Context context){
        mContext=context;
        diaryTableDao=new DiaryTableDao(mContext);
    }


    public DiaryTableDao getDiaryTableDao(){
        return diaryTableDao;
    }

}
