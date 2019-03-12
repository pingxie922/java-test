package com.zzy.javatest.entity.table;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
import lombok.ToString;

/**
 * 操作日志表
 * @author DY10
 *
 */
@Alias("OperationLog")
@Data
@ToString
@TableName(value="operation_log")
public class OperationLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
    private Integer version;
	
	@TableId(value="id",type=IdType.AUTO)
	private Integer id;
	
	private Integer userId;
	
	private Date createTime;
	
	private Short operationType;
	
	private String operationIp;
	
	private Short isDelete;
	
}
