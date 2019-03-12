package com.zzy.javatest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

@Slf4j
@SpringBootApplication
@EnableCaching		//缓存开启的注解
public class JavaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTestApplication.class, args);
        log.info("项目启动成功了");
    }
    
    /**
     * mybatis plus 的乐观锁插件，防止数据脏读
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
