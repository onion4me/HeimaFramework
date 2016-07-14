package com.itheima.zhangjian.config;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:自定义application
 */
public class HeimaApplication extends Application {
    private static HeimaApplication Instance = null;

    private static RequestQueue requestQueue;

    public static final HeimaApplication getAppContext() {
        return Instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
        requestQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    /**
     * 检查网络状态
     * @param contexts
     * @return
     */
    public static boolean isNetworkAvailable(Context contexts) {
        ConnectivityManager connectivity = (ConnectivityManager) contexts.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
