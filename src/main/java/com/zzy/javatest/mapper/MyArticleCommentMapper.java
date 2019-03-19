package com.zzy.javatest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleComment;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2019-03-18
 */
@Mapper
public interface MyArticleCommentMapper extends BaseMapper<MyArticleComment> {

	IPage<MyArticle> getArticleCommentByPage(@Param("page") Page page, @Param("id") Integer id);
	
}
