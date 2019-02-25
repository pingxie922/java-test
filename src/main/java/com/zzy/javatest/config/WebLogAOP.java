/**
 * FileName: WebLogAspect
 * Author:   DY10
 * Date:     2018/12/25 13:57
 * Description: config
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/25 13:57            描述
 */
package com.zzy.javatest.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
/**
 * 〈AOP日志处理〉<br>
 * 〈描述：config〉
 *
 * @author DY10
 * @create 2018/12/25
 * @since 1.0.0
 */
@Slf4j
@Aspect
@Component
public class WebLogAOP {

    @Pointcut("execution(public * com.zzy.javatest.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("请求调用的URL :    " + request.getRequestURL().toString());
        //log.info("请求调用的方式 :   " + request.getMethod());
        log.info("请求调用的类名 :   " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("请求调用的方法名 : " + joinPoint.getSignature().getName());
        log.info("请求调用的参数 :   " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //log.info("请求返回的结果是 : " + ret);
    }

}