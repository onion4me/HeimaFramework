package com.itheima.zhangjian.hm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.zhangjian.config.BaseActivity;
import com.itheima.zhangjian.config.BaseNetActivity;
import com.itheima.zhangjian.network.neturl.BaseManagerType;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:
 */
public class HomeActivity extends BaseNetActivity {

    private TextView mText;

    private Button mButton;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public BaseActivity getThis() {
        return HomeActivity.this;
    }

    @Override
    public void initView(Bundle bundle) {
        mText = (TextView) findViewById(R.id.mText);
    }

    @Override
    public void afterOnCreate(Bundle bundle) {
        getManager(BaseManagerType.MODEL1);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mButton:
                Toast.makeText(getThis(),"adsafsa",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onExecute(int actionKey, String respJson) {

    }

}
