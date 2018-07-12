package mvp.model;

/**
 * 定义网路执行任务（模型数据操作：增删查改）
 * Copyright 星期四 YourCompany.
 */
public interface IShopTask {
    /**
     * 获取商铺列表
     * @param url 请求URL
     * @param callBack 网路回调函数
     */
    public void getShopList(String url,ITaskCallBack callBack);

    /**
     * 获取商铺信息
     * @param url
     * @param callBack
     */
    public void getShopInfo(String url,ITaskCallBack callBack);

    /**
     * 修改商铺信息
     * @param url
     * @param callBack
     */
    public void updateShopInfo(String url,ITaskCallBack callBack);



}
