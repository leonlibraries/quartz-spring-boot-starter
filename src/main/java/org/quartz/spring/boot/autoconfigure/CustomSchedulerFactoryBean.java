package org.quartz.spring.boot.autoconfigure;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 实现该接口允许使用者以编码的方式控制 SchedulerFactoryBean、QuartzProperties,从而实现控制调度器的创建
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/31 18:36 <br/>
 */
public interface CustomSchedulerFactoryBean {

    /**
     * 自定义创建SchedulerFactoryBean
     *
     * @param schedulerFactoryBean 根据配置创建的SchedulerFactoryBean对象
     * @param quartzProperties     配置的读取对象
     * @return 自定义生成的SchedulerFactoryBean
     */
    SchedulerFactoryBean custom(SchedulerFactoryBean schedulerFactoryBean, QuartzProperties quartzProperties);
}
