package com.itheima.zhangjian.network.callback;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：用于UI层数据的回调
 */
public interface ResposeCallback {

    /*** 处理返回结果，返回Json*/
    void onExecute(int actionKey, String respJson);

    /** * 处理请求错误*/
    void onError(int actionkey);

    /*** 处理网络不可访问的情况*/
    void onNetworkError(int actionkey);
}
