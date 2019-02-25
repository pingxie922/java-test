package com.zzy.javatest.entity.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
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
 * @since 2019-01-23
 */
@Aspect("HomeStatement")
@Data
@ToString
@TableName(value="home_statement")
public class HomeStatement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 英语
     */
    @TableField("English")
    private String English;

    /**
     * 汉语
     */
    @TableField("Chinese")
    private String Chinese;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 提供人
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 展示时间
     */
    @TableField("showDate")
    private LocalDateTime showDate;


}
