package org.quartz.spring.boot.autoconfigure;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * 实现Job里的属性能够自动注入<br/>
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/31 18:11 <br/>
 *
 * @see "https://my.oschina.net/coolfire368/blog/290075"
 */
public class AutowireSpringBeanJobFactory extends SpringBeanJobFactory {

    /**
     * Holding an auto wire capable bean spring bean factory.
     */
    private AutowireCapableBeanFactory beanFactory;

    public AutowireSpringBeanJobFactory(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
