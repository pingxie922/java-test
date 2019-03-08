package com.zzy.javatest.entity.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import org.aspectj.lang.annotation.Aspect;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2019-03-07
 */
@Aspect("Banner")
@Data
@ToString
@TableName(value="banner")
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * banner地址
     */
    private String url;

    /**
     * 图片的链接
     */
    private String path;

    @TableField("createDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 到期时间
     */
    @TableField("expirationDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;

    /**
     * 是否删除  0不删除  1删除
     */
    @TableField("isDelete")
    private Integer isDelete;


}
