package com.bigDragon.springIOC;

import com.bigDragon.model.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * ApplicationContext的应用
 *
 *      BeanFactory实现了IoC控制，所以它可以称为IoC容器，而ApplicationContext扩展了BeanFactory容器彬添加了
 * 对118N（国际化）、生命周期事件的发布监听等更加强大的功能，使之称为Spring中强大的企业级IoC容器。在这个容器
 * 中提供了对其他框架和EHB的集成、远程调用、WebService、任务调度和JNDI等企业服务。在Spring应用中大多数采用
 * ApplicationContext容器来开发企业级的程序。
 *
 *      ApplicationContext接口有3个实现类，可以实例化其中任何一个类来创建Spring的ApplicationContext容器。
 *          1)ClassPathXmlApplicationContext类
 *          2)FileSystemXmlApplicationContext类
 *          3)WebApplicationContext类
 * @author bigDragon
 * @create 2020-09-11 14:12
 */
public class ApplicationContextTest {
    public static void main(String[] args){
        ApplicationContextTest applicationContextTest = new ApplicationContextTest();
        applicationContextTest.test();
    }
    public void test(){
        String configLocation1 = "config/applicationContent.xml";
        String configLocation2 = "C:\\Users\\3759\\IdeaProjects\\spring_study\\src\\main\\resources\\applicationContent.xml";
        //ClassPathXmlApplicationContext类
        //从当前类路径中检索配置文件并装载它来创建容器的实例
        ApplicationContext context1 = new ClassPathXmlApplicationContext(configLocation1);
        Test test = (Test)context1.getBean("test");
        System.out.println(test.toString());

        //FileSystemXmlApplicationContext类
        //与ClassPathXmlApplicationContext类的区别在于读取Spring配置文件的方式。它不再从类路径中获取配置文件，
        //  而是通过参数指定配置文件的位置，可以获取类路径之外的资源。
        ApplicationContext context2 = new FileSystemXmlApplicationContext(configLocation2);
        Test test2 = (Test)context2.getBean("test");
        System.out.println(test2.toString());

        //WebApplicationContext类
        //WebApplicationContext是Spring的Web应用容器，有两种方式可以再Servlet中使用WebApplicationContext。
        //  第一种是在Servlet的web.xml文件中配置Spring的ContextLoaderListener监听。
        //  第二种是修改web.xml配置文件，在配置文件中加一个Servlet，定义使用Spring的
        //      org.springframework.web.context.ContextLoaderServlet类。
    }
}
