package com.itheima.zhangjian.network.manager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.itheima.zhangjian.config.HeimaApplication;
import com.itheima.zhangjian.network.callback.RequestCallback;
import com.itheima.zhangjian.network.callback.ResposeCallback;
import com.itheima.zhangjian.network.request.HeimaRequest;
import com.itheima.zhangjian.utils.LogManager;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：发起请求并处理响应
 */
public class BaseManager implements RequestCallback {

    protected RequestQueue requestQueue = null;

    protected Map<String, String> headersMap = null;

    public BaseManager() {
        requestQueue = HeimaApplication.getAppContext().getRequestQueue();
        headersMap = new HashMap<>();
    }

    public void proxyPostBusinessResponse(int method, int actionKey, String actionUrl,
                                          Map<String, String> paras, final ResposeCallback netResult, boolean isShowDialog) {
        beforeTaskExcute();
        postBusinessResponse(method, actionKey, actionUrl, paras, netResult, isShowDialog);
        return;
    }

    /***
     * 请发求起之前  框架：共性问题，不做个体考虑 钩子（预留 用的时候挂上来 不用的时候）
     **/
    @Override
    public void beforeTaskExcute() {

        //Token信息
        headersMap.put("token", "");
        //app版本号
        headersMap.put("x-client-appver", "");
        //设备型号
        headersMap.put("x-client-device", "");
        //设备id
        headersMap.put("x-client-devid", "");
        //客户端系统版本
        headersMap.put("x-client-osver", "");

        LogManager.getLogger().e("content %s,token %s,appver %s,devid %s",
                "在这里处理了请求之前的事情","token是123adsg","appver是1.0","devid是18813149600");
    }

    /**
     * 发送请求  请求方法为get
     *
     * @param actionKey
     * @param actionUrl
     * @param mCallback
     **/
    @Override
    public void getBusinessResponse(int actionKey, String actionUrl, ResposeCallback mCallback, boolean isShowDialog) {

    }

    /**
     * 发送请求  请求方法为post
     *
     * @param method
     * @param actionKey
     * @param actionUrl
     * @param params
     * @param mCallback
     **/
    @Override
    public void postBusinessResponse(int method, int actionKey, String actionUrl, Map<String, String> params,
                                     ResposeCallback mCallback, boolean isShowDialog) {

        Assert.assertNotNull(requestQueue);
        Assert.assertNotNull(headersMap);
        Assert.assertNotNull(mCallback);

        final Response.Listener<String> listener = this.genHttpSuccessListener(actionKey, mCallback);
        Response.ErrorListener errorListener = this.genHttpErrorListener(actionKey, mCallback);

        //逻辑数据？？？？？
        boolean available = HeimaApplication.isNetworkAvailable(HeimaApplication.getAppContext());

        if (available) {
            HeimaRequest.MapRequest(method, actionKey,requestQueue, actionUrl, params, headersMap, listener, errorListener);
        } else {
            // 通过回调通知 UI 网络异常  int 类型的 actionKey
            mCallback.onNetworkError(actionKey);
        }
    }

    /**
     * 请求发送成功之后需要处理的事情
     **/
    @Override
    public void afterTaskExcute() {
        LogManager.getLogger().e("content: %s","在这里处理了请求之后的事情");
    }


    protected Response.Listener<String> genHttpSuccessListener(final int actionKey,
                                                               final ResposeCallback netResult) {
        final Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String respString) {
                //IOS 不识别 null
                if (null == respString || "".equals(respString)){
                    netResult.onError(actionKey);
                }else{
                    netResult.onExecute(actionKey, respString);
                }
//                afterTaskExcute();
            }
        };
        return listener;
    }


    protected Response.ErrorListener genHttpErrorListener(final int actionKey,
                                                          final ResposeCallback netResult) {
        Response.ErrorListener errorListener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
                //  NoConnectionError
                netResult.onNetworkError(actionKey);
            }
        };
        return errorListener;
    }
}
