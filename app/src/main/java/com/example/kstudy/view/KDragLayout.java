package com.example.kstudy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;

import com.example.kstudy.R;

public class KDragLayout extends LinearLayout {

    private static final String TAG = KDragLayout.class.getSimpleName();
    private ViewDragHelper viewDragHelper;
    private TextView dragChildView;
    private boolean isEnableHorizontalDrag = false;
    private boolean isEnableVerticalDrag = false;

    public KDragLayout(Context context){
        this(context,null);
        //init();
    }

    public KDragLayout(Context context, AttributeSet attributeSet){
        this(context,attributeSet,0);
        //init();
    }

    public KDragLayout(Context context , AttributeSet attributeset, int defStyle){
        super(context,attributeset,defStyle);
        init();
    }

    private void init() {
        viewDragHelper = ViewDragHelper.create(this,1f,new DragHelper());
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        dragChildView = findViewById(R.id.tv_drag);
    }

    private class DragHelper extends ViewDragHelper.Callback{

        //  not static inner Class has perssion to call the method or field of outer class
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
           return child == dragChildView;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            if(isEnableHorizontalDrag){
                if(getPaddingLeft() > left) {
                    Log.e(TAG,"getPaddingLeft"+getPaddingLeft());
                    return getPaddingLeft();
                }
                if(getWidth() - getPaddingRight() - child.getWidth() < left) {
                    Log.e(TAG,"getWidth() - child.getWidth()"+(getWidth() - child.getWidth()));
                    return getWidth() - getPaddingRight() - child.getWidth();
                }
                return left;
            }else
                return super.clampViewPositionHorizontal(child, left, dx);
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            if(isEnableVerticalDrag){
                if(getPaddingTop() > top){
                    Log.e(TAG,"getPaddingTop()"+getPaddingTop());
                    return getPaddingTop();
                }

                if(getHeight() - getPaddingBottom() - child.getHeight() < top) {
                    Log.e(TAG,"getHeight() - child.getHeight()"+(getHeight() - child.getHeight()));
                    return getHeight() - getPaddingBottom() - child.getHeight();
                }
                return top;

            }else
            return super.clampViewPositionVertical(child, top, dy);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    public void setEnableHorizontalDrag(){
        this.isEnableHorizontalDrag = true;
    }

    public void setEnableVerticalDrag(){
        this.isEnableVerticalDrag = true;
    }

}
