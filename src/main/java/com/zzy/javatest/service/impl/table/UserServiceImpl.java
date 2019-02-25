package com.zzy.javatest.service.impl.table;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.mapper.UserMapper;
import com.zzy.javatest.service.table.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：impl〉
 *
 * @author DY10
 * @create 2018/12/19
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;
	
    @Override
    public List<User> getAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20);
        return userMapper.selectList(queryWrapper);
    }

}












