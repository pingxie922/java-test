package com.zzy.javatest.entity.table;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
import lombok.ToString;

@Aspect("ThirdApiLog")
@Data
@ToString
@TableName(value="third_api_log")
public class ThirdApiLog {

	@Version
    private Integer version;
	
	@TableId(value="id",type=IdType.AUTO)
	private int id;
	
	private int thirdApiTypeId;
	
	private String returnData;
	
	private Date createDate;
	
	private String telphone;
	
}
