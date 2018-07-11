package com.liqy.searchapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @file FileName
 * SearchApp
 *  * liqy
 * Copyright 星期三 YourCompany.
 */
public class VolleyUtil {

    private static  volatile VolleyUtil util;//单例
    private static RequestQueue queue;//请求队列
    private static Context context;//上下文环境

    /**
     * 构造方法
     */
    public VolleyUtil() {
        context=App.context;
        queue= Volley.newRequestQueue(context);
    }

    /**
     * 获取单例
     * @return
     */
    public static VolleyUtil  getVolley(){
        if (util==null){//第一重检测
            synchronized (VolleyUtil.class){
                if (util==null){
                    util=new VolleyUtil();
                }
            }
        }

        return util;
    }

    /**
     * 添加请求到队列，定义泛型方法
     * @param request
     * @param <T>
     */
    public <T> void addToQueue(Request<T> request){
        queue.add(request);
    }

}
