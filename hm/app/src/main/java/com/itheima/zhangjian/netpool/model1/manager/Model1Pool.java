package com.itheima.zhangjian.netpool.model1.manager;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.android.volley.Request;
import com.itheima.zhangjian.network.callback.ResposeCallback;
import com.itheima.zhangjian.network.manager.BaseManager;
import com.itheima.zhangjian.network.neturl.ApiEnvironment;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：模块1的网络请求管理器
 */
public class Model1Pool extends BaseManager {

    public static Model1Pool manager = null;

    public static BaseManager getInstance() {
        synchronized (Model1Pool.class) {
            if (manager == null) {
                manager = new Model1Pool();
            }
        }
        return manager;
    }

    /**
     * 登陆
     * @param activityContext 上下文
     * @param username  用户名
     * @param userpass  用户密码
     */
    public void login(ResposeCallback activityContext, String username, String userpass) {

        //业务数据
        Map<String, String> map = new HashMap<>();
        map.put("name", username);
        map.put("pass", userpass);

        //准备request参数
        //post  http请求方式    userLoginCode int类型 userLogin String类型的url
        proxyPostBusinessResponse(Request.Method.POST, ApiEnvironment.userLoginCode, ApiEnvironment.userLogin,
                map, activityContext, false);

    }

    public static String getImei(String imei) {
        StringBuffer sb = new StringBuffer();
        int il = imei.length();
        for (int i = 0; i < 32 - il; i++) {
            sb.append("0");
        }
        sb.append(imei);
        return sb.toString();
    }


    /**
     * 获取设备ID
     **/
    public static String GetDevicesId(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }
}
