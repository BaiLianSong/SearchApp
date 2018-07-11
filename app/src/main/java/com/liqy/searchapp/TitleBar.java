package com.liqy.searchapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @file FileName
 * SearchApp
 *  * liqy
 * Copyright 星期三 YourCompany.
 */
public class TitleBar extends RelativeLayout{

    TextView title;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * 初始化
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {

        //初始化视图
        View view= LayoutInflater.from(context).inflate(R.layout.bar_layout,this);
        title=(TextView)view.findViewById(R.id.bar_txt_title);

        //初始化属性
        if (attrs!=null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
            String str=typedArray.getString(R.styleable.TitleBar_BarTitle);
            title.setText(str);
            typedArray.recycle();// 回收资源 防止内存溢出
        }
    }

    /**
     * 通过代码设置标题
     * @param str
     */
    public void serTitle(String str){
        title.setText(str);
    }




}
