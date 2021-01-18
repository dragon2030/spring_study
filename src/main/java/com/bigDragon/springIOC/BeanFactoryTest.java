package com.bigDragon.springIOC;

import com.bigDragon.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 使用BeanFactory管理bean(废弃方法不建议使用)
 *      对于Factory模式，BeanFactory采用了Java经典的工厂模式，通过从XML配置文件或属性文件（.properties）
 * 中读取JavaBean的定义，来实现JavaBean的创建、配置和管理。BeanFactory有很多实例类，其中XmlBeanFactory
 * 可以通过流行的XML文件格式读取配置信息来装载JavaBean。
 *
 * 需要思考解决的问题：
 *  xml文件学习
 *  spring配置文件标头学习
 *
 * @author bigDragon
 * @create 2020-09-10 19:48
 */
public class BeanFactoryTest {
    private static final Logger logger = LoggerFactory.getLogger(BeanFactoryTest.class);
    public static void main(String[] args){
        BeanFactoryTest beanFactory = new BeanFactoryTest();
        //使用BeanFactory管理bean
        beanFactory.test();
    }

    /**
     * 使用BeanFactory管理bean
     */
    public void test(){
        //ClassPathResource读取XML文件并传参给XmlBeanFactory
        Resource resource = new ClassPathResource("applicationContent.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        //在<beans>标签中通过<bean>标签定义JavaBean的名称和类型，在程序代码中利用BeanFactory的getBean()
        //  方法获取JavaBean的实例并且向上转为需要的接口类型，这样在容器中就开始了这个JavaBean的生命周期
        Test test = (Test)factory.getBean("test");
        //Spring中bean的生命周期包括实例化JavaBean，初始化JavaBean、使用JavaBean和销毁JavaBean4个阶段
        test.setName("Mike");
        logger.info(test.toString());
    }
}
