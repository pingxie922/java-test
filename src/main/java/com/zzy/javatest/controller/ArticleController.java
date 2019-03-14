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

import com.zzy.javatest.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
