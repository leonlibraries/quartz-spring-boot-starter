package org.quartz.spring.boot.autoconfigure;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Quartz的自动配置初始化
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/27 18:45 <br/>
 */
@Configuration
@ConditionalOnClass({Scheduler.class, SchedulerFactoryBean.class})
@ConditionalOnMissingBean(Scheduler.class)
@EnableConfigurationProperties(QuartzProperties.class)
public class QuartzAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(QuartzAutoConfiguration.class);

    @Autowired
    private QuartzProperties quartzProperties;

    @Bean(destroyMethod = "destroy")
    @ConditionalOnMissingBean(value = {SchedulerFactoryBean.class, Scheduler.class})
    public SchedulerFactoryBean quartzScheduler(ApplicationContext applicationContext) {
        logger.info("Creating SchedulerFactoryBean ....");
        SchedulerFactoryBean factory = BeanUtils.instantiateClass(SchedulerFactoryBean.class);
        factory.setApplicationContext(applicationContext);
        factory.setTransactionManager(applicationContext.getBean(PlatformTransactionManager.class));
        factory.setJobFactory(new AutowireSpringBeanJobFactory(applicationContext));

        // 已经整合的属性
        factory.setSchedulerFactoryClass(quartzProperties.getSchedulerFactoryClass());
        factory.setSchedulerName(quartzProperties.getSchedulerName());
        factory.setConfigLocation(quartzProperties.getConfigLocation());
        factory.setQuartzProperties(quartzProperties.getQuartzProperties());
        factory.setApplicationContextSchedulerContextKey(quartzProperties.getApplicationContextSchedulerContextKey());
        factory.setAutoStartup(quartzProperties.isAutoStartup());
        factory.setStartupDelay(quartzProperties.getStartupDelay());
        factory.setPhase(quartzProperties.getPhase());
        factory.setExposeSchedulerInRepository(quartzProperties.isExposeSchedulerInRepository());
        factory.setWaitForJobsToCompleteOnShutdown(quartzProperties.isWaitForJobsToCompleteOnShutdown());
        factory.setOverwriteExistingJobs(quartzProperties.isOverwriteExistingJobs());

        // 自定义整合属性
        factory.setDataSource(getDataSource(applicationContext));

        // TODO 定义回调接口允许在其它位置操作 SchedulerFactoryBean、QuartzProperties

        logger.info("Created SchedulerFactoryBean!");
        return factory;
    }

    /**
     * 获取数据库连接源
     */
    private DataSource getDataSource(ApplicationContext applicationContext) {
        DataSource dataSource = null;
        Map<String, DataSource> dataSourceMap = applicationContext.getBeansOfType(DataSource.class);
        if (dataSourceMap == null || dataSourceMap.size() <= 0) {
            throw new BeanInitializationException("DataSource未注入SpringContext");
        }
        if (StringUtils.hasLength(quartzProperties.getDataSourceBeanName())) {
            dataSource = dataSourceMap.get(quartzProperties.getDataSourceBeanName());
        } else if (dataSourceMap.size() == 1) {
            dataSource = dataSourceMap.values().iterator().next();
        }
        if (dataSource == null) {
            throw new BeanInitializationException("Quartz数据源获取失败");
        }
        return dataSource;
    }
}
