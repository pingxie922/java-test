/**
 * FileName: ArticleController
 * Author:   DY10
 * Date:     2019/3/14 17:42
 * Description: controller
 * History:
 * <author>          <time>               <desc>
 * 扬          2019/3/14 17:42            描述
 */
package com.zzy.javatest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.service.ArticleService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：controller〉
 *
 * @author DY10
 * @create 2019/3/14
 * @since 1.0.0
 */
@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article")
    public String toRead(){
        return "article";
    }

    /**
	 * 点赞和阅读
	 * @return
	 */
	@RequestMapping("/article/addLike")
	@ResponseBody
	public Map<String, Object> addLike(Integer id, String str) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = articleService.addLike(id, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
    
	/**
	 * 获取文章
	 * @return
	 */
	@RequestMapping("/article/getComment")
	@ResponseBody
	public IPage<MyArticle> getComment(Long page, Integer id) {
		IPage<MyArticle> list = null;
		if (page == null || page == 0){
			page = 1L;
		}
		Long size = 10L;
		Page<Object> objectPage = new Page<>(page, size);
		try {
			log.info("第几页：" + page + "每页几条：" + size);
			list = articleService.getArticleCommentByPage(objectPage, id);
			log.info("返回结果" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
