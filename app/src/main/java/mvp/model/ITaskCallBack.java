package mvp.model;

/**
 * 定义回调函数
 * Copyright 星期四 YourCompany.
 */
public interface ITaskCallBack {
    public void pre();//网络初始化
    public void update();//网络请求中
    public void success(RootData data);//请求请求返回数据
    public void failed(String msg);//数据处理失败
}
