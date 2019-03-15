package com.zzy.javatest.service.table;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.javatest.entity.table.MyArticle;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yang
 * @since 2019-03-12
 */
public interface MyArticleService extends IService<MyArticle> {

    IPage<MyArticle> getAllArticle(Page page, MyArticle myArticle);

}
