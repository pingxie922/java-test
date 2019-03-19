/**
 * FileName: ArticleService
 * Author:   DY10
 * Date:     2019/3/14 17:43
 * Description: service
 * History:
 * <author>          <time>               <desc>
 * 扬          2019/3/14 17:43            描述
 */
package com.zzy.javatest.service;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.javatest.entity.table.MyArticle;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：service〉
 *
 * @author DY10
 * @create 2019/3/14
 * @since 1.0.0
 */

public interface ArticleService {
	
	Map<String, Object> addLike(Integer id, String str);

	IPage<MyArticle> getArticleCommentByPage(Page<Object> objectPage, Integer id);

}
