package com.zzy.javatest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.service.HomeService;
import com.zzy.javatest.service.table.BannerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	@RequestMapping("/home/getBanner")
	@ResponseBody
	public List<Object> getBanner() {
		List<Object> list = null;
		try {
			list = homeService.getBanner();
			log.info("返回结果" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
