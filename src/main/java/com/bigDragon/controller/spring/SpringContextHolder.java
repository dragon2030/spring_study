package com.bigDragon.controller.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**获取ApplicationContext对象
 * 1.加载Spring配置文件时，如果Spring配置文件中所定义的Bean类实现了ApplicationContextAware 接口，那么在加载Spring配置文件时，会自动调用ApplicationContextAware 接口中的
 * setApplicationContext方法，获得ApplicationContext对象,ApplicationContext对象是由spring注入的。前提必须在Spring配置文件中指定该类。
 * 2.使用静态的成员ApplicationContext类型的对象
 *
 * @author bigDragon
 * @create 2020-10-16 18:14
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
