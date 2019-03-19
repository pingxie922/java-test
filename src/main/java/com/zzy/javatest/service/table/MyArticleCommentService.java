package com.zzy.javatest.service.table;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleComment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yang
 * @since 2019-03-18
 */
public interface MyArticleCommentService extends IService<MyArticleComment> {

	IPage<MyArticle> getArticleCommentByPage(Page page, Integer id);
	
}
