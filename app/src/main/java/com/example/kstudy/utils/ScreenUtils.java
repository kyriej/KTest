package com.example.kstudy.utils;

import android.content.Context;

public class ScreenUtils {

    public static float getScreenDensity(Context context){
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getScreenHeight(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int dip2px(Context context,float dp){
        return (int)(0.5 + dp * getScreenDensity(context));
    }

    public static int px2dip(Context context , float px ){
        return (int)((px - 0.5) / getScreenDensity(context));
    }

}
