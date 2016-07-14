package com.itheima.zhangjian.config;

import android.os.Bundle;
import android.widget.Toast;

import com.itheima.zhangjian.network.callback.RequestCallback;
import com.itheima.zhangjian.network.callback.ResposeCallback;
import com.itheima.zhangjian.network.factory.BaseManagerFactory;
import com.itheima.zhangjian.network.neturl.BaseManagerType;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:网络交互基类
 */
public abstract class BaseNetActivity extends BaseDataActvitity implements ResposeCallback,NetWorkImpl{

    public RequestCallback getManager(BaseManagerType type){
        return  BaseManagerFactory.getInstance(type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void afterOnCreate(Bundle bundle) {

    }

    @Override
    public void onNetworkError(int actionkey) {
        Toast.makeText(getThis(),"请检查网络连接",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int actionkey) {
        Toast.makeText(getThis(),"请求失败",Toast.LENGTH_SHORT).show();
    }
}
