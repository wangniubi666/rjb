package com.example.diary.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.diary.R;
import com.example.diary.model.Model;
import com.example.diary.model.bean.Diaryinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryActivity extends AppCompatActivity {
    private TextView tvDiaryCancel;
    private TextView tvDiarySave;
    private EditText etDiaryTitle;
    private EditText etDiaryContent;
    private LocalBroadcastManager mLBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        mLBM=LocalBroadcastManager.getInstance(DiaryActivity.this);
        initView();
        initListener();
    }

    private void initListener() {
        tvDiaryCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
        tvDiarySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        String title = etDiaryTitle.getText().toString();
        String content = etDiaryContent.getText().toString();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd HH:mm");
        Date time = new Date(System.currentTimeMillis());
        String date=simpleDateFormat.format(time);
        Diaryinfo diaryinfo=new Diaryinfo();
        diaryinfo.setTitle(title);
        diaryinfo.setContent(content);
        diaryinfo.setDate(date);
        Model.getInstance().getDiaryTableDao().saveDiary(diaryinfo);
        mLBM.sendBroadcast(new Intent("diary_change"));
        finish();
    }

    private void cancel() {
        Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void initView() {
        tvDiaryCancel = (TextView)findViewById( R.id.tv_diary_cancel );
        tvDiarySave = (TextView)findViewById( R.id.tv_diary_save );
        etDiaryTitle = (EditText)findViewById( R.id.et_diary_title );
        etDiaryContent = (EditText)findViewById( R.id.et_diary_content );
    }
}
