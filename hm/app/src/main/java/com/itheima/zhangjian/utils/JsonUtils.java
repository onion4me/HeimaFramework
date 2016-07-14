package com.itheima.zhangjian.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itheima.network.neturl.ApiEnvironment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：Gson 数据转换工具
 */
public class JsonUtils {

    /**
     * 创建Gson对象
     * @return
     */
    public static Gson BuildGson() {
        return new GsonBuilder().setDateFormat(ApiEnvironment.DATEFROMAT).create();
    }


    public static JSONObject BuildObject(String result) throws JSONException {
        return new JSONObject(result);
    }


    public static String ToJson(Object obj) {
        Gson gson = BuildGson();
        return gson.toJson(obj);
    }
}
