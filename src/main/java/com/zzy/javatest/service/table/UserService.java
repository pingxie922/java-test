/**
 * FileName: UserService
 * Author:   DY10
 * Date:     2018/12/19 16:15
 * Description: service
 * History:
 * <author>          <time>               <desc>
 * 扬          2018/12/19 16:15            描述
 */
package com.zzy.javatest.service.table;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.javatest.entity.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈描述：service〉
 *
 * @author DY10
 * @create 2018/12/19
 * @since 1.0.0
 */

public interface UserService extends IService<User> {

    List<User> getAll();
    
}











