package com.zzy.javatest.model;

import java.util.Map;

/**
 * 返回结果的类
 * @author DY10
 *
 */
@SuppressWarnings("all")
public class ResultMap {

	 private static final long serialVersionUID = 1L;
	 
	 /**
	  * 成功码 0000
	  * @param msg
	  * @param result
	  * @return
	  */
	 public static Map<String, Object> success(Map<String, Object> map, Object result) {
		 map.put("success", true);
		 map.put("code", "0000");
		 map.put("result", result);
		 return map;
	 }

	 
	 public static Map<String, Object> success(Map<String, Object> map, String msg, Object result) {
		 map.put("success", true);
		 map.put("code", "0000");
		 map.put("msg", msg);
		 map.put("result", result);
		 return map;
	 }
	 
	 public static Map<String, Object> success(Map<String, Object> map, String code, String msg, Object result) {
		 map.put("success", true);
		 map.put("code", code);
		 map.put("msg", msg);
		 map.put("result", result);
		 return map;
	 }
	 
	 /**
	  * 错误码从 1000 开始，不同错误不同错误码
	  * @param msg
	  * @param result
	  * @return
	  */
	 public static Map<String, Object> error(Map<String, Object> map, String msg) {
		 map.put("success", false);
		 map.put("code", "1000");
		 map.put("msg", msg);
		 return map;
	 }
	 
	 public static Map<String, Object> error(Map<String, Object> map, String msg, Object result) {
		 map.put("success", false);
		 map.put("code", "1000");
		 map.put("msg", msg);
		 map.put("result", result);
		 return map;
	 }
	 
	 public static Map<String, Object> error(Map<String, Object> map, String code, String msg, Object result) {
		 map.put("success", false);
		 map.put("code", code);
		 map.put("msg", msg);
		 map.put("result", result);
		 return map;
	 }
	
}
