package com.zzy.javatest.entity.table;

import java.io.Serializable;

import org.aspectj.lang.annotation.Aspect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
import lombok.ToString;

/**
 * 操作字典
 * @author DY10
 *
 */
@Aspect("OperationDictionary")
@Data
@ToString
@TableName(value="operation_dictionary")
public class OperationDictionary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
    private Integer version;
	
	@TableId(value="id",type=IdType.AUTO)
	private Integer id;
	
	private String operation;
	
}
