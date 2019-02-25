/**
 * FileName: DruidDBConfig
 * Author:   DY10
 * Date:     2018/12/21 16:17
 * Description: config
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/21 16:17            描述
 */
package com.zzy.javatest.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 〈阿里连接池监控〉<br>
 *     地址：http://127.0.0.1:8010/demo/druid/sql.html
 * 〈描述：config〉
 *
 * @author DY10
 * @create 2018/12/21
 * @since 1.0.0
 */
@Slf4j
@SuppressWarnings("all")
@Configuration
public class DruidDBConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        /** configuration */
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter" + e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }

    /**
     * http://127.0.0.1:8090/druid/login.html
     *
     * @Title: druidServlet
     * @Description: 注册一个StatViewServlet 相当于在web.xml中声明了一个servlet
     * @param: void
     * @return: ServletRegistrationBean
     * @throws
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        /** 白名单 */
        reg.addInitParameter("allow", "127.0.0.1,115.192.17.238");
        /** IP黑名单(共同存在时，deny优先于allow) */
        // reg.addInitParameter("deny", "192.168.2.105");
        /** /druid/login.html登录时账号密码 */
        reg.addInitParameter("yang", "123456");
        reg.addInitParameter("test", "x123456");
        /** 是否能够重置数据 禁用HTML页面上的“Reset All”功能 */
        reg.addInitParameter("resetEnable", "false");
        return reg;
    }

    /**
     * 注册一个：filterRegistrationBean 相当于在web.xml中声明了一个Filter
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean druidStatFilter = new FilterRegistrationBean();
        druidStatFilter.setFilter(new WebStatFilter());
        /** 添加过滤规则. */
        druidStatFilter.addUrlPatterns("/*");
        /** 监控选项滤器 */
        druidStatFilter.addInitParameter("DruidWebStatFilter", "/*");
        /** 添加不需要忽略的格式信息. */
        druidStatFilter.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.htm,/druid/*");
        /** 配置profileEnable能够监控单个url调用的sql列表 */
        druidStatFilter.addInitParameter("profileEnable", "true");
        /** 当前的cookie的用户 */
        druidStatFilter.addInitParameter("principalCookieName", "USER_COOKIE");
        /** 当前的session的用户 */
        druidStatFilter.addInitParameter("principalSessionName", "USER_SESSION");
        return druidStatFilter;
    }
}