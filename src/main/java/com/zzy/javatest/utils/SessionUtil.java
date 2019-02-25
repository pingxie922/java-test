package com.zzy.javatest.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("all")
public class SessionUtil {

	public static final String LONGIN_USER = "login_user";
	
	public static final String PHONE_CODE = "phone_code";

	
/*
 * 使用一下方式也可以，或者在controller里面 注入HttpSession或者HttpServletRequest也可以直接使用
  	public static HttpSession createSession(HttpSession session) {
		return session;
	}
	
	public static HttpSession createSession1(HttpServletRequest request) {
		return request.getSession();
	}
*/
	
}
