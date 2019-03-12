package com.zzy.javatest.mapper;

import org.apache.ibatis.annotations.Mapper;

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

}
