package com.zzy.javatest.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private MyArticleStatisticsService myArticleStatisticsService;
	
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
	public IPage<MyArticle> getArticle(Page page) {
		log.info("homeserviceImpl");
		IPage<MyArticle> allArticle = myArticleService.getAllArticle(page);
		if(allArticle != null)
			return allArticle;
		return null;
	}

	@Override
	public Map<String, Object> addLike(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(id != null && id != 0) {
			QueryWrapper<MyArticleStatistics> queryWrapper = new QueryWrapper<MyArticleStatistics>().eq("id", id);
			MyArticleStatistics myArticleStatistics = myArticleStatisticsService.getOne(queryWrapper);
			log.info("查询的结果是：" + myArticleStatistics);
			if(myArticleStatistics == null) {
				ResultMap.error(map, "查询的结果为空");
				return map;
			}
			Integer likeNum = myArticleStatistics.getLikeNum();
			myArticleStatistics.setLikeNum(likeNum+1);
			UpdateWrapper<MyArticleStatistics> updateWrapper = new UpdateWrapper<MyArticleStatistics>().eq("id", id);
			boolean update = myArticleStatisticsService.update(myArticleStatistics, updateWrapper);
			if(update) {
				ResultMap.success(map, myArticleStatistics);
				return map;
			}
			ResultMap.error(map, "修改失败");
			return map;
		}
		ResultMap.error(map, "id为空");
		return map;
	}

	
	
}
