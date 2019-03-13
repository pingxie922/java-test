package com.zzy.javatest.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.entity.table.MyArticle;
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
	 * 获取banner图
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
	
	/**
	 * 获取文章
	 * @param user
	 * @return
	 */
	@RequestMapping("/home/getArticle")
	@ResponseBody
	public IPage<MyArticle> getArticle(Integer page, Integer size) {
		IPage<MyArticle> list = null;
		try {
			log.info("第几页：" + page + "每页几条：" + size);
			list = homeService.getArticle(page, size);
			log.info("返回结果" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
