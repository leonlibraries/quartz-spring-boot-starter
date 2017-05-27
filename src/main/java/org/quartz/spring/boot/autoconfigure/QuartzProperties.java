package org.quartz.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Quartz 属性配置,参考: http://www.quartz-scheduler.org/documentation/quartz-2.2.x/configuration/
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/27 18:26 <br/>
 */
@ConfigurationProperties(prefix = QuartzProperties.QUARTZ_PREFIX)
public class QuartzProperties {
    public static final String QUARTZ_PREFIX = "quartz";

    //==================================================================================
    //              Configure Main Scheduler Settings
    //              主要配置 基本调度器(配置设置, 事务)
    //==================================================================================



    //==================================================================================
    //              Configure ThreadPool Settings
    //              配置ThreadPool (优化资源作业执行)
    //==================================================================================


    //==================================================================================
    //              Configure Global Listeners
    //              配置监听器 (您的应用程序可以接收通知 预定事件)
    //==================================================================================


    //==================================================================================
    //              Configure Scheduler Plugins
    //              配置的插件 (功能添加到您的调度器)
    //==================================================================================





}

