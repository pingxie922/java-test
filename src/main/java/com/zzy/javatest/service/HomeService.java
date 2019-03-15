package com.zzy.javatest.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleStatistics;

public interface HomeService {

	List<Object> getBanner();

	IPage<MyArticle> getArticle(Page page, MyArticle myArticle);

	Map<String, Object> addLike(Integer id);

}
