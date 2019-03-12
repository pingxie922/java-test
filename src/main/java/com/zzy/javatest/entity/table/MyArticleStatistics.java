package com.zzy.javatest.entity.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import org.aspectj.lang.annotation.Aspect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章数据统计
 * </p>
 *
 * @author yang
 * @since 2019-03-12
 */
@Aspect("MyArticleStatistics")
@Data
@ToString
@TableName(value="my_article_statistics")
public class MyArticleStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Integer version;
    
    /**
     *  主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章Id
     */
    @TableField("articleId")
    private Integer articleId;

    /**
     * 收藏数量
     */
    @TableField("collectNum")
    private Integer collectNum;

    /**
     * 点赞数量
     */
    @TableField("likeNum")
    private Integer likeNum;

    /**
     * 阅读量
     */
    @TableField("readNum")
    private Integer readNum;


}
