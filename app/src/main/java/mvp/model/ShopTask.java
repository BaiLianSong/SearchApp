package mvp.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.liqy.searchapp.VolleyUtil;

/**
 * 实现模型接口
 * Copyright 星期四 YourCompany.
 */
public class ShopTask implements IShopTask{

    public ShopTask() {
    }

    /**
     * 获取商铺列表
     * @param url 请求URL
     * @param callBack 网路回调函数
     */
    @Override
    public void getShopList(String url, final ITaskCallBack callBack) {

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson=new Gson();
                RootData data=gson.fromJson(response,RootData.class);
                callBack.success(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.failed(error.getMessage());
            }
        });

        VolleyUtil.getVolley().addToQueue(request);

    }

    /**
     * 获取商铺信息
     * @param url
     * @param callBack
     */
    @Override
    public void getShopInfo(String url, ITaskCallBack callBack) {

    }

    /**
     * 更新商铺信息
     * @param url
     * @param callBack
     */
    @Override
    public void updateShopInfo(String url, ITaskCallBack callBack) {

    }
}
