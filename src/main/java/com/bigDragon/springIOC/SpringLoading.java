package com.bigDragon.springIOC;

import com.bigDragon.spring.SpringContextHolder;
import com.bigDragon.model.User1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**web.xml文件中配置自动加载
 * 在web.xml文件中配置自动加载applicationContext.xml文件,在项目启动时，Spring的配置信息将自动加载到程序中，所以在调用JavaBean时不再需要实例化BeanFactory对象。
 *
 * @author bigDragon
 * @create 2020-10-16 15:26
 */
@Controller
@RequestMapping("/springMVCLoading")
public class SpringLoading {
    private static final Logger logger = LoggerFactory.getLogger(SpringLoading.class);

    @Resource(name="user1")
    private User1 user1;

    /** spring上下文中获取bean属性
     *  @Resource 获取bean方式
     * 执行信息User1{name='小强', age=26, sex='男'}
     * @return
     */
    @RequestMapping(value = "/getBean1")
    @ResponseBody
    public String getBean1(){
        logger.info("getBean1执行");
        System.out.println(user1.toString());
        logger.info("getBean1执行");
        return user1.toString();
    }

    /** spring上下文中获取bean属性
     *  applicationContext手动获取bean方式
     * 执行信息User1{name='小强', age=26, sex='男'}
     * @return
     */
    @RequestMapping(value = "/getBean2")
    @ResponseBody
    public String getBean2(){
        logger.info("getBean2执行");
        User1 user1 = (User1) SpringContextHolder.getBean("user1");
        System.out.println(user1.toString());
        logger.info("getBean2执行");
        return user1.toString();
    }
}
