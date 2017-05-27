package org.quartz.spring.boot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz的自动配置初始化
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2017/5/27 18:45 <br/>
 */
@Configuration
//@ConditionalOnClass({DruidDataSource.class, StatViewServlet.class, WebStatFilter.class})
//@ConditionalOnMissingBean(DataSource.class)
//@EnableConfigurationProperties(DruidProperties.class)
public class QuartzAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(QuartzAutoConfiguration.class);


}
