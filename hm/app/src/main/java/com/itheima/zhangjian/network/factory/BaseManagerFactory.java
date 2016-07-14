package com.itheima.zhangjian.network.factory;

import com.itheima.zhangjian.netpool.model1.manager.Model1Pool;
import com.itheima.zhangjian.netpool.model2.manager.Mode2Pool;
import com.itheima.zhangjian.network.callback.RequestCallback;
import com.itheima.zhangjian.network.neturl.BaseManagerType;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：网络请求控制器工厂
 */
public class BaseManagerFactory {

    public static RequestCallback getInstance(BaseManagerType type){
        RequestCallback manager = null;
        switch(type){
            case MODEL1:
                manager = Model1Pool.getInstance();
                break;
            case MODEL2:
                manager = Mode2Pool.getInstance();
                break;
        }
        return manager;
    }

}
