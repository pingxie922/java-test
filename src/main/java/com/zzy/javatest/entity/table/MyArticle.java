package com.zzy.javatest.entity.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

import com.zzy.javatest.entity.User;
import org.aspectj.lang.annotation.Aspect;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author yang
 * @since 2019-03-12
 */
@Aspect("MyArticle")
@Data
@ToString
@TableName(value="my_article")
public class MyArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Integer version;
    
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 是否删除  0不删除  1删除
     */
    @TableField("isDelete")
    private Integer isDelete;

    /**
     * 作者
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 编辑时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("createDate")
    private Date createDate;
    
    /**
     * 简介
     */
    private String introduction;
    
    private String tag;

    private MyArticleStatistics myArticleStatistics;

    private User user;
}
