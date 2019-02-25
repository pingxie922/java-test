package com.zzy.javatest.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.javatest.entity.User;
import com.zzy.javatest.service.LoginService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(User user) {
		Map<String, Object> map = null;
		try {
			map = loginService.login(user);
			log.info("返回结果" + map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/reg")
	@ResponseBody
	public Map<String, Object> reg(User user, String phonecode){
		Map<String, Object> map = null;
		try {
			map = loginService.reg(user, phonecode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 判断用户手机号是否存在，并发送验证码
	 * @return
	 */
	@RequestMapping("/isExistByPhone")
	@ResponseBody
	public Map<String, Object> isExistByPhone(String telPhone){
		Map<String, Object> map = null;
		try {
			map = loginService.isExistByTelPhone(telPhone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取首页的语句
	 * @return
	 */
	@RequestMapping("/getHomeStateMent")
	@ResponseBody
	public Map<String, Object> getHomeStateMent(){
		Map<String, Object> map = null;
		try {
			map = loginService.getHomeStateMent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
}












