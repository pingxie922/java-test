package com.zzy.javatest.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.entity.table.Banner;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleStatistics;
import com.zzy.javatest.model.ResultMap;
import com.zzy.javatest.service.HomeService;
import com.zzy.javatest.service.table.BannerService;
import com.zzy.javatest.service.table.MyArticleService;
import com.zzy.javatest.service.table.MyArticleStatisticsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private MyArticleService myArticleService;
	
	@Override
	public List<Object> getBanner() {
		QueryWrapper<Banner> queryWrapper = new QueryWrapper<Banner>()
				.ge("expirationDate", new Date())
				.eq("isDelete", 0);
		List<Object> list = bannerService.listObjs(queryWrapper);
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

	@Override
	public IPage<MyArticle> getArticle(Page page, MyArticle myArticle) {
		log.info("homeserviceImpl");
		IPage<MyArticle> allArticle = myArticleService.getAllArticle(page, myArticle);
		if(allArticle != null)
			return allArticle;
		return null;
	}

}
