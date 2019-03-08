package com.zzy.javatest.config;

import com.zzy.javatest.model.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * springboot拦截器
 * 拦截器是针对于部分Web请求（Action请求）;常用于登陆拦截，审计日志;拦截器的拦截是基于java的反射机制实现的
 * 	1. LogInterceptor 实现 HandlerInterceptor 接口，或者继承HanlerInterceptorAdapter类，重写里面的方法
 * 	2. 在 WebIntegerceptorConfig里继承WebMvcConfigurationSupport或者WebMvcConfigurerAdapter（已过时）类 或者实现WebMvcConfigurer接口
 * 		重写里面的addInterceptors()方法，添加拦截器
 * 		// 解决跨域问题
		//public void addCorsMappings(CorsRegistry registry) ;
		// 添加拦截器 
		//void addInterceptors(InterceptorRegistry registry);
		// 这里配置视图解析器 
		//void configureViewResolvers(ViewResolverRegistry registry);
		// 配置内容裁决的一些选项 
		//void configureContentNegotiation(ContentNegotiationConfigurer configurer);
		// 视图跳转控制器 
		//void addViewControllers(ViewControllerRegistry registry);
		// 静态资源处理 
		//void addResourceHandlers(ResourceHandlerRegistry registry);
		// 默认静态资源处理器 
		//void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
 */
@SuppressWarnings("all")
@Configuration
public class WebInterceptorConfig extends WebMvcConfigurationSupport {
	@Autowired
	private LogInterceptor logInterceptor;

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor).excludePathPatterns("/static/**","/templates/**","/UserLogin/**","/home.do","/home/**");//.excludePathPatterns("/adminUser/login")过滤哪些不拦截的请求
		super.addInterceptors(registry);
	}
	/**
	 * 静态 资源处理
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	}
	
	/**
	 * 配置dispatcherServlet，在路径访问时添加后缀才可以访问
	 * @param dispatcherServlet
	 * @return
	 */
	@SuppressWarnings("rawtypes")		//取消报黄
	@Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        servletServletRegistrationBean.addUrlMappings("*.html");
        servletServletRegistrationBean.addUrlMappings("*.css");
        servletServletRegistrationBean.addUrlMappings("*.js");
        servletServletRegistrationBean.addUrlMappings("*.png");
        servletServletRegistrationBean.addUrlMappings("*.gif");
        servletServletRegistrationBean.addUrlMappings("*.ico");
        servletServletRegistrationBean.addUrlMappings("*.jpeg");
        servletServletRegistrationBean.addUrlMappings("*.jpg");
        servletServletRegistrationBean.addUrlMappings("*.json");
        return servletServletRegistrationBean;
    }

}
