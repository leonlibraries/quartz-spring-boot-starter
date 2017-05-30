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


//
//
//        ================================================================================================= Configure Main Scheduler Settings
//        org.quartz.scheduler.instanceName 	no 	string 	'QuartzScheduler'
//        org.quartz.scheduler.instanceId 	no 	string 	'NON_CLUSTERED'
//        org.quartz.scheduler.instanceIdGenerator.class 	no 	string (class name) 	org.quartz.simpl.SimpleInstanceIdGenerator
//        org.quartz.scheduler.threadName 	no 	string 	instanceName+ '_QuartzSchedulerThread'
//        org.quartz.scheduler.makeSchedulerThreadDaemon 	no 	boolean 	false
//        org.quartz.scheduler.threadsInheritContextClassLoaderOfInitializer 	no 	boolean 	false
//        org.quartz.scheduler.idleWaitTime 	no 	long 	30000
//        org.quartz.scheduler.dbFailureRetryInterval 	no 	long 	15000
//        org.quartz.scheduler.classLoadHelper.class 	no 	string (class name) 	org.quartz.simpl.CascadingClassLoadHelper
//        org.quartz.scheduler.jobFactory.class 	no 	string (class name) 	org.quartz.simpl.PropertySettingJobFactory
//        org.quartz.context.key.SOME_KEY 	no 	string 	none
//        org.quartz.scheduler.userTransactionURL 	no 	string (url) 	'java:comp/UserTransaction'
//        org.quartz.scheduler.wrapJobExecutionInUserTransaction 	no 	boolean 	false
//        org.quartz.scheduler.skipUpdateCheck 	no 	boolean 	false
//        org.quartz.scheduler.batchTriggerAcquisitionMaxCount 	no 	int 	1
//        org.quartz.scheduler.batchTriggerAcquisitionFireAheadTimeWindow 	no 	long 	0
//
//
//        ================================================================================================= Configure ThreadPool Settings
//        org.quartz.threadPool.class 	yes 	string (class name) 	null
//        org.quartz.threadPool.threadCount 	yes 	int 	-1
//        org.quartz.threadPool.threadPriority 	no 	int 	Thread.NORM_PRIORITY (5)
//
//        org.quartz.threadPool.makeThreadsDaemons 	no 	boolean 	false
//        org.quartz.threadPool.threadsInheritGroupOfInitializingThread 	no 	boolean 	true
//        org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread 	no 	boolean 	false
//        org.quartz.threadPool.threadNamePrefix 	no 	string 	[Scheduler Name]_Worker
//
//        org.quartz.threadPool.class = com.mycompany.goo.FooThreadPool
//        org.quartz.threadPool.somePropOfFooThreadPool = someValue
//
//
//
//        ================================================================================================= Configure Global Listeners
//        org.quartz.triggerListener.NAME.class = com.foo.MyListenerClass
//        org.quartz.triggerListener.NAME.propName = propValue
//        org.quartz.triggerListener.NAME.prop2Name = prop2Value
//
//        org.quartz.jobListener.NAME.class = com.foo.MyListenerClass
//        org.quartz.jobListener.NAME.propName = propValue
//        org.quartz.jobListener.NAME.prop2Name = prop2Value
//
//
//
//
//        ================================================================================================= Configure Scheduler Plugins
//        org.quartz.plugin.NAME.class = com.foo.MyPluginClass
//        org.quartz.plugin.NAME.propName = propValue
//        org.quartz.plugin.NAME.prop2Name = prop2Value
//
//        org.quartz.plugin.triggHistory.class = \
//        org.quartz.plugins.history.LoggingTriggerHistoryPlugin
//        org.quartz.plugin.triggHistory.triggerFiredMessage = \
//        Trigger \{1\}.\{0\} fired job \{6\}.\{5\} at: \{4, date, HH:mm:ss MM/dd/yyyy}
//        org.quartz.plugin.triggHistory.triggerCompleteMessage = \
//        Trigger \{1\}.\{0\} completed firing job \{6\}.\{5\} at \{4, date, HH:mm:ss MM/dd/yyyy\}.
//
//        org.quartz.plugin.jobInitializer.class = \
//        org.quartz.plugins.xml.XMLSchedulingDataProcessorPlugin
//        org.quartz.plugin.jobInitializer.fileNames = \
//        data/my_job_data.xml
//        org.quartz.plugin.jobInitializer.failOnFileNotFound = true
//
//        org.quartz.plugin.shutdownhook.class = \
//        org.quartz.plugins.management.ShutdownHookPlugin
//        org.quartz.plugin.shutdownhook.cleanShutdown = true
//
//        ================================================================================================= Configure RMI Settings
//        org.quartz.scheduler.rmi.export 	no 	false
//        org.quartz.scheduler.rmi.registryHost 	no 	'localhost'
//        org.quartz.scheduler.rmi.registryPort 	no 	1099
//        org.quartz.scheduler.rmi.createRegistry 	no 	'never'
//        org.quartz.scheduler.rmi.serverPort 	no 	random
//        org.quartz.scheduler.rmi.proxy 	no 	false
//
//
//
//        ================================================================================================= Configure RAMJobStore
//        org.quartz.jobStore.class = org.quartz.simpl.RAMJobStore
//
//        org.quartz.jobStore.misfireThreshold 	no 	int 	60000
//
//
//        ================================================================================================= Configure JDBC-JobStoreTX
//        org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreTX
//
//        org.quartz.jobStore.driverDelegateClass 	yes 	string 	null
//        org.quartz.jobStore.dataSource 	yes 	string 	null
//        org.quartz.jobStore.tablePrefix 	no 	string 	"QRTZ_"
//        org.quartz.jobStore.useProperties 	no 	boolean 	false
//        org.quartz.jobStore.misfireThreshold 	no 	int 	60000
//        org.quartz.jobStore.isClustered 	no 	boolean 	false
//        org.quartz.jobStore.clusterCheckinInterval 	no 	long 	15000
//        org.quartz.jobStore.maxMisfiresToHandleAtATime 	no 	int 	20
//        org.quartz.jobStore.dontSetAutoCommitFalse 	no 	boolean 	false
//        org.quartz.jobStore.selectWithLockSQL 	no 	string 	"SELECT * FROM {0}LOCKS WHERE SCHED_NAME = {1} AND LOCK_NAME = ? FOR UPDATE"
//        org.quartz.jobStore.txIsolationLevelSerializable 	no 	boolean 	false
//        org.quartz.jobStore.acquireTriggersWithinLock 	no 	boolean 	false (or true - see doc below)
//        org.quartz.jobStore.lockHandler.class 	no 	string 	null
//        org.quartz.jobStore.driverDelegateInitString 	no 	string 	null
//
//
//        ================================================================================================= Configure JDBC-JobStoreCMT
//        org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreCMT
//
//        org.quartz.jobStore.driverDelegateClass 	yes 	string 	null
//        org.quartz.jobStore.dataSource 	yes 	string 	null
//        org.quartz.jobStore.nonManagedTXDataSource 	yes 	string 	null
//        org.quartz.jobStore.tablePrefix 	no 	string 	"QRTZ_"
//        org.quartz.jobStore.useProperties 	no 	boolean 	false
//        org.quartz.jobStore.misfireThreshold 	no 	int 	60000
//        org.quartz.jobStore.isClustered 	no 	boolean 	false
//        org.quartz.jobStore.clusterCheckinInterval 	no 	long 	15000
//        org.quartz.jobStore.maxMisfiresToHandleAtATime 	no 	int 	20
//        org.quartz.jobStore.dontSetAutoCommitFalse 	no 	boolean 	false
//        org.quartz.jobStore.dontSetNonManagedTXConnectionAutoCommitFalse 	no 	boolean 	false
//        org.quartz.jobStore.selectWithLockSQL 	no 	string 	"SELECT * FROM {0}LOCKS WHERE SCHED_NAME = {1} AND LOCK_NAME = ? FOR UPDATE"
//        org.quartz.jobStore.txIsolationLevelSerializable 	no 	boolean 	false
//        org.quartz.jobStore.txIsolationLevelReadCommitted 	no 	boolean 	false
//        org.quartz.jobStore.acquireTriggersWithinLock 	no 	boolean 	false (or true - see doc below)
//        org.quartz.jobStore.lockHandler.class 	no 	string 	null
//        org.quartz.jobStore.driverDelegateInitString 	no 	string 	null
//
//
//
//        ================================================================================================= Configure DataSources
//        org.quartz.dataSource.NAME.driver 	yes 	String 	null
//        org.quartz.dataSource.NAME.URL 	yes 	String 	null
//        org.quartz.dataSource.NAME.user 	no 	String 	""
//        org.quartz.dataSource.NAME.password 	no 	String 	""
//        org.quartz.dataSource.NAME.maxConnections 	no 	int 	10
//        org.quartz.dataSource.NAME.validationQuery 	no 	String 	null
//        org.quartz.dataSource.NAME.idleConnectionValidationSeconds 	no 	int 	50
//        org.quartz.dataSource.NAME.validateOnCheckout 	no 	boolean 	false
//        org.quartz.dataSource.NAME.discardIdleConnectionsSeconds 	no 	int 	0 (disabled)
//
//        org.quartz.dataSource.NAME.jndiURL 	yes 	String 	null
//        org.quartz.dataSource.NAME.java.naming.factory.initial 	no 	String 	null
//        org.quartz.dataSource.NAME.java.naming.provider.url 	no 	String 	null
//        org.quartz.dataSource.NAME.java.naming.security.principal 	no 	String 	null
//        org.quartz.dataSource.NAME.java.naming.security.credentials 	no 	String 	null
//
//        org.quartz.dataSource.NAME.connectionProvider.class 	yes 	String (class name) 	null
//
//
//        =================================================================================================
//
//
//
