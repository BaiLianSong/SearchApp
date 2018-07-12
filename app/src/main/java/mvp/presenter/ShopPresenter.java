package mvp.presenter;

import android.util.Log;

import mvp.model.IShopTask;
import mvp.model.ITaskCallBack;
import mvp.model.RootData;
import mvp.model.ShopTask;
import mvp.view.IShopView;
import mvp.view.ShopListActivity;

/**
 * @file FileName
 * SearchApp
 *  * liqy
 * Copyright 星期四 YourCompany.
 */
public class ShopPresenter implements IShopPresenter, ITaskCallBack {

    /**
     * 注入M层
     */
    IShopTask shopTask;

    /**
     * 注入V层
     */

    IShopView shopView;

    /**
     * 构造函数
     *
     * @param activity
     */
    public ShopPresenter(ShopListActivity activity) {
        shopTask = new ShopTask();
        shopView = activity;
    }

    /**
     * 获取列表，调用M层网络请求方法
     */
    @Override
    public void getList() {
        shopTask.getShopList("http://39.108.3.12:3000/v1/restaurants?offset=0&limit=4&lng=116.29845&lat=39.95933", this);
    }

    @Override
    public void pre() {

    }

    @Override
    public void update() {

    }

    @Override
    public void success(RootData data) {
        Log.d("shop", data.toString());
        shopView.showData(data);
    }

    @Override
    public void failed(String msg) {

    }
}
