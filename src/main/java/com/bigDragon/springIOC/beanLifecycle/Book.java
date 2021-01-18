package com.bigDragon.springIOC.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 首先是一个简单的Spring Bean，调用Bean自身的方法和Bean级生命周期接口方法，为了方便演示，它实现了BeanNameAware、
 * BeanFactoryAware、InitializingBean和DiposableBean这4个接口，同时有2个方法，对应配置文件中<bean>的init-method和destroy-method
 * @author bigDragon
 * @create 2021-01-12 15:35
 */
public class Book implements BeanNameAware,BeanFactoryAware,
        ApplicationContextAware,InitializingBean,DisposableBean {

    private String bookName;
    public Book(){
        System.out.println("Book Initializing ");
    }
    //如果Bean实现了BeanFactoryAware接口的话，Spring将调用setBeanFactory()方法，将BeanFactory容器实例传入
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Book.setBeanFactory invoke————BeanFactory接口中方法");
    }
    //如果Bean实现了BeanNameAware接口的话，Spring将Bean的Id传递给setBeanName()方法
    public void setBeanName(String name) {
        System.out.println("Book.setBeanName invoke————BeanNameAware接口中方法");
    }
    //如果bean实现了DisposableBean接口，Spring将调用它的destory()接口方法，同样，如果bean使用了destory-method 声明销毁方法，
    // 该方法也会被调用。
    public void destroy() throws Exception {
        System.out.println("Book.destory invoke");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Book.afterPropertiesSet invoke");
    }
    //如果Bean实现了ApplicationContextAware接口的话，Spring将调用Bean的setApplicationContext()方法，将bean所在应用上下文引用传入进来。
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Book.setApplicationContext invoke————setApplicationContext");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("setBookName: Book name has set.");
    }
    //配置文件中 init-method="myPostConstruct"
    public void myPostConstruct(){
        System.out.println("Book.myPostConstruct invoke");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("@PostConstruct————自定义初始化方法");
    }

    public void myPreDestory(){
        System.out.println("Book.myPreDestory invoke");
        System.out.println("---------------destroy-----------------");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory(){
        System.out.println("@PreDestory————自定义销毁方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}