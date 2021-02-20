/*
package com.bigDragon.springIOC.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

*/
/**
 * BeanPostProcessor接口包括2个方法postProcessAfterInitialization和postProcessBeforeInitialization，这两个方法的第一个参数
 * 都是要处理的Bean对象，第二个参数都是Bean的name。返回值也都是要处理的Bean对象
 * @author bigDragon
 * @create 2021-01-12 15:51
 *//*

public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }
    // 容器加载的时候会加载一些其他的bean，会调用初始化前和初始化后方法
    // 这次只关注book(bean)的生命周期
    //如果Bean实现了BeanPostProcessor接口，Spring就将调用他们的postProcessBeforeInitialization()方法。
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Book){
            System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        }
        return bean;
    }
    //如果Bean 实现了BeanPostProcessor接口，Spring就将调用他们的postProcessAfterInitialization()方法。
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Book){
            System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        }
        return bean;
    }
}
*/
