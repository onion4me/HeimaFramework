package com.itheima.zhangjian.network.neturl;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：工厂管理控制器区分单元
 */
public enum BaseManagerType {
    /**
     * 弦外音：官方不建议大规模使用枚举和反射，存在性能问题!
     *        但是小规模使用枚举，方便业务实现，带来的性能问题几乎可以忽略
     *        关于反射带来的性能问题，有两个解决办法，一个是关闭jvm安全验证，一个是通过编译前绑定解决这个问题。
     */
    MODEL1,MODEL2
}
