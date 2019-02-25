/**
 * FileName: User
 * Author:   DY10
 * Date:     2018/12/19 16:19
 * Description: entity
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/19 16:19            描述
 */
package com.zzy.javatest.entity;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：entity〉
 *
 * @author DY10
 * @create 2018/12/19
 * @since 1.0.0
 */
@Alias("User")
@Data
@ToString
@TableName(value="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     *  乐观锁插件的注解
     *  支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
     *  整数类型下 newVersion = oldVersion + 1
     *  newVersion 会回写到 entity 中
     *  仅支持 updateById(id) 与 update(entity, wrapper) 方法
     *  在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
     */
/*
    @Version
    private Integer version;
*/
	@TableId(value="id",type=IdType.AUTO)		//设置id自增方式为数据库自增的方式
    private Integer id;

    private String name;

    private Integer age;

    private String email;
    
    private String telphone;
    
    private String password;
    
    private String address;
    
    private Short isDelete;
    
    private Date regTime;
    
    private String IDcard;
}
















