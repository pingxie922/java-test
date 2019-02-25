package com.zzy.javatest.model;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzy.javatest.entity.User;
import com.zzy.javatest.utils.SessionUtil;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 * @author DY10
 *
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

	/**
	 *  请求之前   登陆拦截器
	 * return true 不拦截，return false 拦截
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionUtil.LONGIN_USER);
		if(user == null) {
			log.info("被拦截了");
			response.sendRedirect("/demo/toLogin.do");//跳转到登陆页面
			return false;
		} 
		return true;
	}
	/**
	 * 请求中
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 请求之后
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}


}

