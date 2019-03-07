package com.zzy.javatest.service.impl;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.javatest.entity.User;
import com.zzy.javatest.entity.table.HomeStatement;
import com.zzy.javatest.entity.table.OperationLog;
import com.zzy.javatest.model.ResultMap;
import com.zzy.javatest.service.LoginService;
import com.zzy.javatest.service.table.HomeStatementService;
import com.zzy.javatest.service.table.OperationLogService;
import com.zzy.javatest.service.table.UserService;
import com.zzy.javatest.statues.OperationLogDictionary;
import com.zzy.javatest.utils.DateUtil;
import com.zzy.javatest.utils.HttpUtils;
import com.zzy.javatest.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
/**
 * 登陆业务层
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserService userService;
    @Autowired
    private HttpSession session;
    @Autowired
    private OperationLogService operationLogService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
	private HomeStatementService homeStatementService;
    
	@Override
	public Map<String, Object> login(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(StringUtils.isEmpty(user.getTelphone())) {
				ResultMap.error(map, "请输入账号", null);
				return map;
			}
			if(StringUtils.isEmpty(user.getPassword())) {
				ResultMap.error(map, "请输入密码", null);
				return map;
			}
			User loginUser = userService.getOne(new QueryWrapper<User>()
					.eq("telphone", user.getTelphone())
					.eq("password", user.getPassword())
					.ne("isDelete", (short) 1));
			log.info("登陆用户的信息：" + loginUser);
			if(loginUser != null) {					 						//登陆成功，保存登陆日志
				OperationLog operationLog = new OperationLog();
				operationLog.setUserId(loginUser.getId());
				operationLog.setOperationIp(HttpUtils.getIpAddr(request));
				operationLog.setOperationType(OperationLogDictionary.LOGIN.value);
				operationLogService.save(operationLog);
				session.setAttribute(SessionUtil.LONGIN_USER, loginUser);
				ResultMap.success(map, "登陆成功", loginUser, "/demo/home.do");
			} else {														//登陆失败，判断电话号码是否存在，获取用户，存在的话保存登陆失败日志
				User user2 = userService.getOne(new QueryWrapper<User>().eq("telphone", user.getTelphone()));
				if(user2 != null) {
					OperationLog operationLog = new OperationLog();
					operationLog.setUserId(user2.getId());
					operationLog.setOperationIp(HttpUtils.getIpAddr(request));
					operationLog.setOperationType(OperationLogDictionary.LOGIN_ERROR.value);
					operationLogService.save(operationLog);
				}
				ResultMap.error(map, "账号或密码错误，请重试", null);
			}
		} catch (Exception e) {
			ResultMap.error(map, "登陆异常，请稍后重试", null);
			log.info("登陆异常了");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> reg(User user, String phonecode) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(StringUtils.isEmpty(user.getName())) {
				ResultMap.error(map, "用户名为空", null);
				return map;
			}
			if(StringUtils.isEmpty(user.getTelphone())) {
				ResultMap.error(map, "用户手机号为空", null);
				return map;
			}
			if(StringUtils.isEmpty(user.getPassword())) {
				ResultMap.error(map, "用户密码为空", null);
				return map;
			}
			if(StringUtils.isEmpty(phonecode)) {
				ResultMap.error(map, "手机验证码为空", null);
				return map;
			}
			log.info("用户输入的手机验证码:" + phonecode);
			String phone_code = (String) session.getAttribute(SessionUtil.PHONE_CODE);
			log.info("发送的手机验证码:" + phone_code);
			if(StringUtils.isEmpty(phone_code)) {
				ResultMap.error(map, "手机验证码已过期", null);
				return map;
			}
			if(!phone_code.equals(phonecode)) {
				ResultMap.error(map, "手机验证码错误", null);
				return map;
			}
			log.info("注册用户的信息：" + user);
			User regUser = userService.getOne(new QueryWrapper<User>().eq("telphone", user.getTelphone()));
			log.info("用户是否已存在：" + regUser);
			if(regUser != null) {
				ResultMap.error(map, "用户手机号已存在", null);
				return map;
			}
			boolean i = userService.save(user);
			if(i) {
				regUser = userService.getOne(new QueryWrapper<User>().eq("telphone", user.getTelphone()));
				OperationLog operationLog = new OperationLog();
				operationLog.setUserId(regUser.getId());
				operationLog.setOperationIp(HttpUtils.getIpAddr(request));
				operationLog.setOperationType(OperationLogDictionary.REG_USER.value);
				operationLogService.save(operationLog);
				session.removeAttribute(SessionUtil.PHONE_CODE);
				session.setAttribute(SessionUtil.LONGIN_USER, user);
				ResultMap.success(map, "注册成功,更多内容容我开发", user, "/demo/home.do");
			} else {
				ResultMap.error(map, "注册失败，请稍后重试", null);
			}
		} catch (Exception e) {
			log.info("注册异常");
			ResultMap.error(map, "注册失败，请稍后重试", null);
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> isExistByTelPhone(String telPhone) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(StringUtils.isEmpty(telPhone)) {
				ResultMap.error(map, "请输入手机号", null);
				return map;
			}
			User user = userService.getOne(new QueryWrapper<User>().eq("telphone", telPhone));
			if(user != null) {
				ResultMap.error(map, "用户手机号已存在", null);
				return map;
			}
			String random = createRandom(true, 6);//此处调用短信接口发送短信，在这里创建6位随机数字当做验证码在注册返回值里显示
			log.info("手机验证码为：" + random);
			session.setAttribute(SessionUtil.PHONE_CODE, random);
			ResultMap.success(map, "可用", "注册手机验证码 :" + random, null);
		} catch (Exception e) {
			log.info("获取手机验证码异常");
			ResultMap.error(map, "发送验证码失败，请稍后重试", null);
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getHomeStateMent() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String time = DateUtil.getNowDateTime("yyyy-MM-dd");
			log.info("当前日期时间为:" + time);
			HomeStatement one = homeStatementService.getOne(new QueryWrapper<HomeStatement>().likeRight("showDate", time));
			if(one != null) {
				log.info("获取的语句为:" + one);
				ResultMap.success(map, "获取成功", one, null);
			}
		} catch (Exception e) {
			log.info("获取首页语句出错");
			ResultMap.error(map, "发送验证码失败，请稍后重试", null);
			e.printStackTrace();
		}
		return map;
	}
	
	/**
     * 创建指定数量的随机字符串
     * @param numberFlag 是否是数字
     * @param length 长度
     * @return
     */
    public static String createRandom(boolean numberFlag, int length){
	     String retStr = "";
	     String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
	     int len = strTable.length();
	     boolean bDone = true;
	     do {
		      retStr = "";
		      int count = 0;
		      for (int i = 0; i < length; i++) {
			       double dblR = Math.random() * len;
			       int intR = (int) Math.floor(dblR);
			       char c = strTable.charAt(intR);
			       if (('0' <= c) && (c <= '9')) {
			    	   count++;
			       }
			       retStr += strTable.charAt(intR);
		      }
		      if (count >= 2) {
		    	  bDone = false;
		      }
	     } while (bDone);
	    
	     return retStr;
    }

}
