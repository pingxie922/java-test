package com.zzy.javatest.entity.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzy.javatest.entity.User;

import java.time.LocalDateTime;
import java.util.Date;

import org.aspectj.lang.annotation.Aspect;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2019-03-18
 */
@Aspect("MyArticleComment")
@Data
@ToString
@TableName(value="my_article_comment")
public class MyArticleComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章ID
     */
    @TableField("articleId")
    private Integer articleId;

    /**
     * 评论
     */
    private String comment;

    /**
     * 评论时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("commentDate")
    private Date commentDate;

    /**
     * 评论的Id  其他人回复的评论的Id
     */
    @TableField("commentId")
    private Integer commentId;

    /**
     * 评论者
     */
    @TableField("commentUserId")
    private Integer commentUserId;

    /**
     * 是否删除  0不删除  1删除
     */
    @TableField("isDelete")
    private Integer isDelete;

    /**
     * 乐观锁
     */
    private Integer version;

    private User user;
}
