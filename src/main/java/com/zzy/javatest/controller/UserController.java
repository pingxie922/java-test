/**
 * FileName: UserController
 * Author:   DY10
 * Date:     2018/12/13 15:44
 * Description: controller
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/13 15:44            描述
 */
package com.zzy.javatest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.service.table.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈描述：controller〉
 *
 * @author DY10
 * @create 2018/12/13
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	@Cacheable(value = "myCache1")
	public List<User> getUser() {
		List<User> all = userService.getAll();
		return all;
	}

	/**
	 * 此方法让UserService 继承IService 在UserServiceImpl中实现page方法，便可使用 ，仅限单表查询分页
	 * jianshe52052a@163.com d2RjK8xa
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/getPage")
	public IPage<User> getAllPage(int page, int size) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.gt("age", 18).lt("age", 40);
		log.info("这里了");
		IPage<User> result = userService.page(new Page<>(page, size), queryWrapper);
		return result;
	}

}
