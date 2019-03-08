package com.zzy.javatest.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.javatest.entity.table.Banner;
import com.zzy.javatest.service.HomeService;
import com.zzy.javatest.service.table.BannerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private BannerService bannerService;
	
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

	
	
}
