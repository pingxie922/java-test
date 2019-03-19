package com.zzy.javatest.service.impl.table;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleStatistics;
import com.zzy.javatest.mapper.MyArticleStatisticsMapper;
import com.zzy.javatest.service.table.MyArticleStatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2019-03-12
 */
@Service
public class MyArticleStatisticsServiceImpl extends ServiceImpl<MyArticleStatisticsMapper, MyArticleStatistics> implements MyArticleStatisticsService {

	@Autowired
	private MyArticleStatisticsMapper mapper;
	

}




