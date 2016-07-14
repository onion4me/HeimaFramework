package com.itheima.zhangjian.netpool.model2.manager;

import com.android.volley.Request;
import com.itheima.zhangjian.network.callback.ResposeCallback;
import com.itheima.zhangjian.network.manager.BaseManager;
import com.itheima.zhangjian.network.neturl.ApiEnvironment;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：模块2的网络请求管理器
 */
public class Mode2Pool extends BaseManager {

    public static Mode2Pool manager = null;

    public static BaseManager getInstance() {
        synchronized (Mode2Pool.class) {
            if (manager == null) {
                manager = new Mode2Pool();
            }
        }
        return manager;
    }

    public void Model2RequestTest(ResposeCallback miidoCallback, String content, String contens) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", content);
        map.put("key2", contens);
        proxyPostBusinessResponse(Request.Method.POST, ApiEnvironment.model1Code,
                ApiEnvironment.model1, map, miidoCallback, false);
    }
}
