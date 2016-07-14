package com.itheima.zhangjian.utils;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：Log日志输出类型区分
 */
public class Logger {
    public Logger() { }

    public void v(String format, Object... args)  { }

    public void d(String format, Object... args)  { }

    public void i(String format, Object... args)  { }

    public void w(String format, Object... args)  { }

    public void w(Throwable tr, String format, Object... args)  { }

    public void e(String format, Object... args)  { }

    public void e(Throwable tr, String format, Object... args)  { }

    public void wtf(String format, Object... args)  { }

    public void wtf(Throwable tr, String format, Object... args)  { }
}
