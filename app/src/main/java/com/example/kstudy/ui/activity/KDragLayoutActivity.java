package com.example.kstudy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kstudy.R;
import com.example.kstudy.view.KDragLayout;

public class KDragLayoutActivity extends AppCompatActivity {

    private String flag;
    private KDragLayout kDragLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdrag);
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");
        kDragLayout = findViewById(R.id.kdrag_layout);
        if(flag.equals("v")) {
            Log.e("----------","v");
            kDragLayout.setEnableVerticalDrag();
        }
        else if(flag.equals("h")){
            Log.e("---------","h");
            kDragLayout.setEnableHorizontalDrag();
        }

    }
}
