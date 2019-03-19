/**
 * FileName: ArticleServiceImpl
 * Author:   DY10
 * Date:     2019/3/14 17:43
 * Description: impl
 * History:
 * <author>          <time>               <desc>
 * 扬          2019/3/14 17:43            描述
 */
package com.zzy.javatest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.table.MyArticle;
import com.zzy.javatest.entity.table.MyArticleStatistics;
import com.zzy.javatest.model.ResultMap;
import com.zzy.javatest.service.ArticleService;
import com.zzy.javatest.service.table.MyArticleCommentService;
import com.zzy.javatest.service.table.MyArticleStatisticsService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：impl〉
 *
 * @author DY10
 * @create 2019/3/14
 * @since 1.0.0
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private MyArticleStatisticsService myArticleStatisticsService;
	
	@Autowired
	private MyArticleCommentService myArticleCommentService;
	
	@Override
	public Map<String, Object> addLike(Integer id, String str) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(id != null && id != 0) {
			QueryWrapper<MyArticleStatistics> queryWrapper = new QueryWrapper<MyArticleStatistics>().eq("id", id);
			MyArticleStatistics myArticleStatistics = myArticleStatisticsService.getOne(queryWrapper);
			log.info("查询的结果是：" + myArticleStatistics);
			if(myArticleStatistics == null) {
				ResultMap.error(map, "查询的结果为空");
				return map;
			}
			if(StringUtils.isNotEmpty(str) && "likeNum".equals(str)) {
				Integer likeNum = myArticleStatistics.getLikeNum();
				myArticleStatistics.setLikeNum(likeNum+1);
			} 
			if(StringUtils.isNotEmpty(str) && "readNum".equals(str)) {
				Integer readNum = myArticleStatistics.getReadNum();
				myArticleStatistics.setReadNum(readNum+1);
			}
			UpdateWrapper<MyArticleStatistics> updateWrapper = new UpdateWrapper<MyArticleStatistics>().eq("id", id);
			boolean update = myArticleStatisticsService.update(myArticleStatistics, updateWrapper);
			if(update) {
				ResultMap.success(map, myArticleStatistics);
				return map;
			}
			ResultMap.error(map, "修改失败");
			return map;
		}
		ResultMap.error(map, "id为空");
		return map;
	}

	@Override
	public IPage<MyArticle> getArticleCommentByPage(Page<Object> objectPage, Integer id) {
		IPage<MyArticle> allArticle = myArticleCommentService.getArticleCommentByPage(objectPage, id);
		if(allArticle != null)
			return allArticle;
		return null;
	}


}



