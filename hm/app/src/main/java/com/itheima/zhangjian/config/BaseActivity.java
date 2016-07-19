package com.itheima.zhangjian.config;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:第二层UI相关配置基类
 */
public abstract class BaseActivity extends Activity implements  ActivityImpl,View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /**
         * 获取布局
         */
        setContentView(getLayout());
        /**
         * 绑定view
         */
        initView(savedInstanceState);
        /**
         * 事件，数据等交互行为
         */
        afterOnCreate(savedInstanceState);
        /**
         * 将实现类填装到ActivityManager自定义栈
         */
        ActivityManager.addView(getThis());

        ButterKnife.bind(getThis());
    }
}
