package com.zzy.javatest.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzy.javatest.entity.table.MyArticle;

public interface HomeService {

	List<Object> getBanner();

	IPage<MyArticle> getArticle(Integer object, Integer object2);

}
