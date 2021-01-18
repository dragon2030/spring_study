package com.bigDragon;

import com.bigDragon.springAOP.AOPMain;
import com.bigDragon.springIOC.SpringBean;
import com.bigDragon.springIOC.ApplicationContextTest;
import com.bigDragon.springIOC.AutowireTest;
import com.bigDragon.springIOC.BeanFactoryTest;
import com.bigDragon.springIOC.IoCTest;
import com.bigDragon.springIOC.SpringLoading;

/**
 * spring框架学习
 *
 * 遗留问题：
 * 1.记录HTTP会话实现，cookie，session使用和理解 需要功力深厚以后写个demo https://blog.csdn.net/xiaoxinshuaiga/article/details/91038337
 * 2.记录token令牌 https://www.cnblogs.com/lufeiludaima/p/pz20190203.html
 * 3.遗留问题：ServletUpload类 未完成 等之后看过io源码之后 在对上传下载进行对比书写
 * 4.遗留问题：context:component-scan配置无法和当前spring版本兼容
 * 5.https://www.runoob.com/w3cnote/java-annotation.html Java 注解（Annotation)
 * @author bigDragon
 * @create 2020-09-11 14:10
 */
public class Main {
    public static void main(String[] args){
        //spring IoC对bean的管理
        //使用BeanFactory管理bean
        BeanFactoryTest.main(args);
        //使用ApplicationContext管理bean
        ApplicationContextTest.main(args);
        //web.xml文件中配置自动加载applicationContext.xml文件管理bean
        new SpringLoading();

        //spring IoC依赖注入
        IoCTest.main(args);
        //Servlet学习整理
        com.bigDragon.servletTest.Main.main(args);
        //spring Ioc自动装配
        new AutowireTest();
        //bean的作用域
        new SpringBean();

        //Spring AOP
        new AOPMain();


    }
}
