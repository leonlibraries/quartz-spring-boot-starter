package org.quartz.spring.boot.autoconfigure;

import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Quartz 属性配置,参考: http://www.quartz-scheduler.org/documentation/quartz-2.2.x/configuration/
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/27 18:26 <br/>
 */
@ConfigurationProperties(prefix = QuartzProperties.QUARTZ_PREFIX)
public class QuartzProperties {
    static final String QUARTZ_PREFIX = "quartz";

    //-------------------------------------------------------------------------------------- 已经整合的属性

    /**
     * SchedulerFactory实现类名称
     */
    private Class<? extends SchedulerFactory> schedulerFactoryClass = StdSchedulerFactory.class;

    /**
     * 调度器名称,quartz.properties文件里的org.quartz.scheduler.instanceName配置无用,必须在此处设置设置schedulerName
     */
    private String schedulerName;

    /**
     * quartz配置文件路径,如: classpath:/quartz/quartz.properties
     */
    private Resource configLocation;

    /**
     * 自定义Quartz Properties(优先级高于configLocation文件中的配置)
     */
    private Properties quartzProperties;

    /**
     * Spring容器(applicationContext)在调度器容器(SchedulerContext)中的Key值
     */
    private String applicationContextSchedulerContextKey;

    /**
     * 是否自动启动调度器
     */
    private boolean autoStartup = true;

    /**
     * 设置延时启动调度器的时间(单位:秒)
     */
    private int startupDelay = 0;

    /**
     * 设置调度器启动的优先级
     */
    private int phase = Integer.MAX_VALUE;

    /**
     * 保留调度器实例在 SchedulerRepository 中
     */
    private boolean exposeSchedulerInRepository = false;

    /**
     * 关闭调度时，是否等待所有的job执行完毕
     */
    private boolean waitForJobsToCompleteOnShutdown = false;
    /**
     * 是否覆盖存在的任务
     */
    private boolean overwriteExistingJobs = false;

    //-------------------------------------------------------------------------------------- 未完成整合的属性

//    /**
//     * 任务执行器
//     */
//    private Executor taskExecutor;
//
//    /**
//     * 数据源 -- 已获取
//     */
//    private DataSource dataSource;
//
//    /**
//     * 不支持事务的数据源
//     */
//    private DataSource nonTransactionalDataSource;
//
//    /**
//     * 调度器容器数据
//     */
//    private Map<String, ?> schedulerContextMap;
//
//    /**
//     * Spring容器 -- 已获取
//     */
//    private ApplicationContext applicationContext;
//
//    /**
//     * 任务创建工厂 -- 已获取
//     */
//    private JobFactory jobFactory;
//
//    /**
//     * 是否设置了 JobFactory -- 已获取
//     */
//    private boolean jobFactorySet = false;
//
//    private String[] jobSchedulingDataLocations;
//
//    private List<JobDetail> jobDetails;
//
//    private Map<String, Calendar> calendars;
//
//    private List<Trigger> triggers;
//
//    private SchedulerListener[] schedulerListeners;
//
//    private JobListener[] globalJobListeners;
//
//    private TriggerListener[] globalTriggerListeners;
//
//    private PlatformTransactionManager transactionManager; // -- 已获取
//
//    private ResourceLoader resourceLoader;

    //-------------------------------------------------------------------------------------- 自定义整合属性

    /**
     * 定义使用的数据源BeanName
     */
    private String dataSourceBeanName;


    /*--------------------------------------------------------------
    *          getter、setter
    * -------------------------------------------------------------*/

    public Class<? extends SchedulerFactory> getSchedulerFactoryClass() {
        return schedulerFactoryClass;
    }

    public void setSchedulerFactoryClass(Class<? extends SchedulerFactory> schedulerFactoryClass) {
        this.schedulerFactoryClass = schedulerFactoryClass;
    }

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public Resource getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public Properties getQuartzProperties() {
        return quartzProperties;
    }

    public void setQuartzProperties(Properties quartzProperties) {
        this.quartzProperties = quartzProperties;
    }

    public String getApplicationContextSchedulerContextKey() {
        return applicationContextSchedulerContextKey;
    }

    public void setApplicationContextSchedulerContextKey(String applicationContextSchedulerContextKey) {
        this.applicationContextSchedulerContextKey = applicationContextSchedulerContextKey;
    }

    public boolean isAutoStartup() {
        return autoStartup;
    }

    public void setAutoStartup(boolean autoStartup) {
        this.autoStartup = autoStartup;
    }

    public int getStartupDelay() {
        return startupDelay;
    }

    public void setStartupDelay(int startupDelay) {
        this.startupDelay = startupDelay;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isExposeSchedulerInRepository() {
        return exposeSchedulerInRepository;
    }

    public void setExposeSchedulerInRepository(boolean exposeSchedulerInRepository) {
        this.exposeSchedulerInRepository = exposeSchedulerInRepository;
    }

    public boolean isWaitForJobsToCompleteOnShutdown() {
        return waitForJobsToCompleteOnShutdown;
    }

    public void setWaitForJobsToCompleteOnShutdown(boolean waitForJobsToCompleteOnShutdown) {
        this.waitForJobsToCompleteOnShutdown = waitForJobsToCompleteOnShutdown;
    }

    public boolean isOverwriteExistingJobs() {
        return overwriteExistingJobs;
    }

    public void setOverwriteExistingJobs(boolean overwriteExistingJobs) {
        this.overwriteExistingJobs = overwriteExistingJobs;
    }

    public String getDataSourceBeanName() {
        return dataSourceBeanName;
    }

    public void setDataSourceBeanName(String dataSourceBeanName) {
        this.dataSourceBeanName = dataSourceBeanName;
    }

    //-----------------------------------------------------------------------------------------------

//    public Executor getTaskExecutor() {
//        return taskExecutor;
//    }
//
//    public void setTaskExecutor(Executor taskExecutor) {
//        this.taskExecutor = taskExecutor;
//    }
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public DataSource getNonTransactionalDataSource() {
//        return nonTransactionalDataSource;
//    }
//
//    public void setNonTransactionalDataSource(DataSource nonTransactionalDataSource) {
//        this.nonTransactionalDataSource = nonTransactionalDataSource;
//    }
//
//    public Map<String, ?> getSchedulerContextMap() {
//        return schedulerContextMap;
//    }
//
//    public void setSchedulerContextMap(Map<String, ?> schedulerContextMap) {
//        this.schedulerContextMap = schedulerContextMap;
//    }
//
//    public ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    public JobFactory getJobFactory() {
//        return jobFactory;
//    }
//
//    public void setJobFactory(JobFactory jobFactory) {
//        this.jobFactory = jobFactory;
//    }
//
//    public boolean isJobFactorySet() {
//        return jobFactorySet;
//    }
//
//    public void setJobFactorySet(boolean jobFactorySet) {
//        this.jobFactorySet = jobFactorySet;
//    }
//
//    public String[] getJobSchedulingDataLocations() {
//        return jobSchedulingDataLocations;
//    }
//
//    public void setJobSchedulingDataLocations(String[] jobSchedulingDataLocations) {
//        this.jobSchedulingDataLocations = jobSchedulingDataLocations;
//    }
//
//    public List<JobDetail> getJobDetails() {
//        return jobDetails;
//    }
//
//    public void setJobDetails(List<JobDetail> jobDetails) {
//        this.jobDetails = jobDetails;
//    }
//
//    public Map<String, Calendar> getCalendars() {
//        return calendars;
//    }
//
//    public void setCalendars(Map<String, Calendar> calendars) {
//        this.calendars = calendars;
//    }
//
//    public List<Trigger> getTriggers() {
//        return triggers;
//    }
//
//    public void setTriggers(List<Trigger> triggers) {
//        this.triggers = triggers;
//    }
//
//    public SchedulerListener[] getSchedulerListeners() {
//        return schedulerListeners;
//    }
//
//    public void setSchedulerListeners(SchedulerListener[] schedulerListeners) {
//        this.schedulerListeners = schedulerListeners;
//    }
//
//    public JobListener[] getGlobalJobListeners() {
//        return globalJobListeners;
//    }
//
//    public void setGlobalJobListeners(JobListener[] globalJobListeners) {
//        this.globalJobListeners = globalJobListeners;
//    }
//
//    public TriggerListener[] getGlobalTriggerListeners() {
//        return globalTriggerListeners;
//    }
//
//    public void setGlobalTriggerListeners(TriggerListener[] globalTriggerListeners) {
//        this.globalTriggerListeners = globalTriggerListeners;
//    }
//
//    public PlatformTransactionManager getTransactionManager() {
//        return transactionManager;
//    }
//
//    public void setTransactionManager(PlatformTransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }
//
//    public ResourceLoader getResourceLoader() {
//        return resourceLoader;
//    }
//
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
}
