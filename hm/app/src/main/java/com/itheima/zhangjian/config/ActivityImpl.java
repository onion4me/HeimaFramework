package com.itheima.zhangjian.config;

import android.os.Bundle;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:
 */
public interface ActivityImpl {

    /**
     *获取layout布局信息
     * @return  layout布局
     */
    int getLayout();

    /**
     * 获取上下文信息
     * @return
     */
    BaseActivity getThis();

    /**
     * 初始化控件
     * @param bundle 基类传递bundle
     */
    void initView(Bundle bundle);

    /**
     * 非UI的初始化动作
     * @param bundle 基类传递bundle
     */
    void afterOnCreate(Bundle bundle);
}
