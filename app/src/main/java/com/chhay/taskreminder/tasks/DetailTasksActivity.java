package com.chhay.taskreminder.tasks;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chhay.taskreminder.R;

public class DetailTasksActivity extends AppCompatActivity{
    TextView detailtitle;
    TextView detaildate;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tasks);

        detailtitle = (TextView) findViewById(R.id.txt_title);
        detaildate = (TextView) findViewById(R.id.txt_date);

        String tmpName = getIntent().getStringExtra("title");
        String tmpDate = getIntent().getStringExtra("date");

        detailtitle.setText(tmpName);
        detaildate.setText(tmpDate);
    }
}


