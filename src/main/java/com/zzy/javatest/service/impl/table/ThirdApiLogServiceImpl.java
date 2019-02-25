package com.zzy.javatest.service.impl.table;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.javatest.entity.table.ThirdApiLog;
import com.zzy.javatest.mapper.ThirdApiLogMapper;
import com.zzy.javatest.service.table.ThirdApiLogService;

@Service
public class ThirdApiLogServiceImpl extends ServiceImpl<ThirdApiLogMapper, ThirdApiLog> implements ThirdApiLogService {

}
