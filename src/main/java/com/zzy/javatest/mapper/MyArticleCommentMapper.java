package com.zzy.javatest.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

}
