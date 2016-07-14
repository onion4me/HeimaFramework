package com.itheima.zhangjian.network.callback;

import java.util.Map;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：发送请求的回调
 */
public interface RequestCallback {

    /*** 请求发起之前的准备工作**/
    void beforeTaskExcute();

    /**  发送请求  请求方法为get**/
    void getBusinessResponse(int actionKey, String actionUrl,
                             final ResposeCallback mCallback, boolean isShowDailog);

    /**  发送请求  请求方法为post**/
    void postBusinessResponse(int method, int actionKey, String actionUrl,
                              Map<String, String> params, final ResposeCallback mCallback, boolean isShowDailog);

    /**  请求发送成功之后需要处理的事情**/
    void afterTaskExcute();

}
