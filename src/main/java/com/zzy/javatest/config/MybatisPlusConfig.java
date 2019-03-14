/**
 * FileName: MybatisPlusConfig
 * Author:   DY10
 * Date:     2018/12/20 10:23
 * Description: config
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/20 10:23            描述
 */
package com.zzy.javatest.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 〈mybatis-plus的分页插件〉<br>
 * 〈描述：config〉
 *
 * @author DY10
 * @create 2018/12/20
 * @since 1.0.0
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     */
    /*@Bean
    //@Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/

    /**
     * 乐观锁插件
     *  乐观锁实现方式：
          取出记录时，获取当前version
          更新时，带上这个version
          执行更新时， set version = newVersion where version = oldVersion
          如果version不对，就更新失败
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
