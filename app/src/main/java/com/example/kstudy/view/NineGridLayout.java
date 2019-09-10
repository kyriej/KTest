package com.example.kstudy.view;

import android.content.Context;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.kstudy.R;

import java.util.List;

public class NineGridLayout extends ViewGroup {

    private Context mContext;
    private int gap = 5;//图片之间间隔
    private int columns; // 列数
    private int rows; // 行数
    private List mDatas;


    public NineGridLayout(Context context){
        this(context,null);
    }

    public NineGridLayout(Context context , AttributeSet attributeSet){
        this(context,attributeSet,0);
    }

    public NineGridLayout(Context context , AttributeSet attributeSet , int defStyleId){
        super(context,attributeSet,defStyleId);
        mContext = context;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
       // R.styleable.
        TypedArray typedArray = mContext.obtainStyledAttributes(attributeSet,R.styleable.NineGridLayout);


    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
