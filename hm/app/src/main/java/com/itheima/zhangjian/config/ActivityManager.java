package com.itheima.zhangjian.config;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:ZHANGJIAN  on 2016/7/14.
 * 邮箱:zhangjian1@itcast.cn
 * 说明:
 */
public class ActivityManager {

    public static List<Activity> activityList = new ArrayList<>();

    /**
     * 加入一个Activity
     *
     * @param activity
     */
    public static void addView(Activity activity){
        activityList.add(activity);
    }

    /**
     * 清除一个Activity
     * @param activity
     */
    public void finishActivity(Activity activity){
        if(activity!=null){
            activityList.remove(activity);
            activity.finish();
            activity=null;
        }
    }

    /**
     * 清除所有Activity
     */
    public void finishAllActivity(){
        while(activityList.size() > 0) {
            Activity activity = activityList.get(activityList.size() - 1);
            activityList.remove(activityList.size() - 1);
            activity.finish();
        }
    }
}
