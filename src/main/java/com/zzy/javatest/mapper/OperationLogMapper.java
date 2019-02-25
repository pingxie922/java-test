package com.zzy.javatest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.javatest.entity.table.OperationLog;

@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {

}
