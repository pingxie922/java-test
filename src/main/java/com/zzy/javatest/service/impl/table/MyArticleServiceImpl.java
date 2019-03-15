package com.zzy.javatest.service.impl.table;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.mapper.MyArticleMapper;
import com.zzy.javatest.service.table.MyArticleService;
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
public class MyArticleServiceImpl extends ServiceImpl<MyArticleMapper, MyArticle> implements MyArticleService {

    @Autowired
    private MyArticleMapper mapper;

    @Override
    public IPage<MyArticle> getAllArticle(Page page, MyArticle myArticle) {
        return mapper.getAllArticle(page, myArticle);
    }
}
