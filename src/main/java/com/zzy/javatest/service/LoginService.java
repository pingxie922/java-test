package com.zzy.javatest.service;

import java.util.Map;

import com.zzy.javatest.entity.User;

public interface LoginService {

	 /**
     * 用户登陆方法
     * @return
     */
	Map<String, Object> login(User user);

	/**
	 * 用户注册方法
	 * @param user
	 * @return
	 */
	Map<String, Object> reg(User user, String phonecode);

	Map<String, Object> isExistByTelPhone(String telPhone);

	Map<String, Object> getHomeStateMent();
	
}
