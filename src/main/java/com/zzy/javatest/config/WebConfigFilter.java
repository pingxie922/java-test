/**
 * FileName: WebFilter
 * Author:   DY10
 * Date:     2018/12/24 15:21
 * Description: config
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/24 15:21            描述
 */
package com.zzy.javatest.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 〈过滤器〉<br>
 * 〈描述：config〉
 *	过滤器是对所有Web请求有效，是通过函数回调实现的，常用于敏感词过滤，设置字符编码，url的级别权限设置
 *	实现 Filter接口 ，重写里面的方法
 *
 * @author DY10
 * @create 2018/12/24
 * @since 1.0.0
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "WebConfigFilter")
public class WebConfigFilter implements Filter {
    /**
     * 过滤器初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    /**
     * 过滤器执行
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.printf("过滤器实现");
        System.out.println(((HttpServletRequest) servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 过滤器销毁
     */
    @Override
    public void destroy() {
        System.out.println("过滤器销毁了");
    }
}




















