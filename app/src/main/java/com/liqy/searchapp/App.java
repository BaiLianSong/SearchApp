package com.liqy.searchapp;

import android.app.Application;
import android.content.Context;

/**
 * @file FileName
 * SearchApp
 *  * liqy
 * Copyright 星期三 YourCompany.
 */
public class App extends Application{

    public  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
