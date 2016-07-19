package com.itheima.zhangjian.config;

import android.widget.Toast;

import com.itheima.zhangjian.network.callback.ResposeCallback;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:第三层网络交互相关配置基类
 */
public abstract class BaseNetActivity extends BaseDataActvitity implements ResposeCallback,NetWorkImpl{

    @Override
    public void onNetworkError(int actionkey) {
        Toast.makeText(getThis(),"请检查网络连接",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int actionkey) {
        Toast.makeText(getThis(),"请求失败",Toast.LENGTH_SHORT).show();
    }
}
