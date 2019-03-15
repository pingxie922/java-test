package com.zzy.javatest.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.javatest.entity.table.MyArticle;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2019-03-12
 */
@Mapper
public interface MyArticleMapper extends BaseMapper<MyArticle> {

	IPage<MyArticle> getAllArticle(@Param("page") Page page, @Param("myArticle") MyArticle myArticle);
	
}
