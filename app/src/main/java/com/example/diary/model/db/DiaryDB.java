package com.example.diary.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.diary.model.dao.DiaryTable;

public class DiaryDB extends SQLiteOpenHelper {
    public DiaryDB(@Nullable Context context) {
        super(context, "diary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DiaryTable.CREATE_TAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
