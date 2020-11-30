package com.example.diary.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.diary.R;

public class DiaryDetailActivity extends AppCompatActivity {
    private TextView tv_diarydetail_content;
    private TextView tv_diarydetail_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        tv_diarydetail_title.setText(intent.getStringExtra("title"));
        tv_diarydetail_content.setText(intent.getStringExtra("content"));
    }

    private void initView() {
        tv_diarydetail_title = findViewById(R.id.tv_diarydetail_title);
        tv_diarydetail_content = findViewById(R.id.tv_diarydetail_content);
    }
}
