package com.zzy.javatest.service.impl.table;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleComment;
import com.zzy.javatest.mapper.MyArticleCommentMapper;
import com.zzy.javatest.service.table.MyArticleCommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2019-03-18
 */
@Service
public class MyArticleCommentServiceImpl extends ServiceImpl<MyArticleCommentMapper, MyArticleComment> implements MyArticleCommentService {

	@Autowired MyArticleCommentMapper mapper;
	
	@Override
	public IPage<MyArticle> getArticleCommentByPage(Page page, Integer id) {
		return mapper.getArticleCommentByPage(page, id);
	}

}
