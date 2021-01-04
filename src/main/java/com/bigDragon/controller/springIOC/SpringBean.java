package com.bigDragon.controller.springIOC;

import com.bigDragon.controller.spring.SpringContextHolder;
import com.bigDragon.model.User1;
import com.bigDragon.model.User5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的作用域
 * Spring IoC容器管理一个或多个bean，这些bean将通过配置文件中的bean定义被创建（在XML格式中为<bean/>元素）。所以要了解Spring中bean，应该重点了解配置文件中的<bean>元素。
 *      <bean>元素的属性及说明
 *          id：代表JavaBean的实例对象。在JavaBean实例化后可以通过id来引用其实例对象
 *          name：代表JavaBean的实例对象名
 *          class：JavaBean的类名，元素的必选属性
 *          singleton:是否使用单实例
 *          autowire:Spring的JavaBean自动装配功能
 *          init-method:指定JavaBean的初始化方法
 *          destroy-method:指定JavaBean被回收之前调用的销毁方法
 *          depends-on: 用于保证在depends-on指定的JavaBean被实例化之后，再实例化自身JavaBean
 *
 *      singleton的作用域：
 *          当Spring中一个bean的作用域为singleton时，那么SpringIoC容器中只会存在一个共享的该bean实例，并且所有对该bean的引用，只要id与该bean定义相匹配，则只会返回bean的单一实例。
 *          在设置bean singleton作用域是，有三种方式：
 *              <bean id="user1" class="com.bigDragon.model.User1"/>                    //默认即为singleton作用域
 *              <bean id="user1" class="com.bigDragon.model.User1" singleton="true"/>   //将singleton属性设置为true
 *              <bean id="user1" class="com.bigDragon.model.User1" scope="singleton"/>  //利用scope属性指定
 *      prototype的作用域：
 *          prototype作用域的bean会导致在每次对该bean请求（将其注入到另一个bean中，或者调用容器的getBean（）方法）时都会撞见一个行的bean实例。
 *          有两种方式可以设置bean prototype作用域：
 *              <bean id="user1" class="com.bigDragon.model.User1" singleton="false"/>  //将singleton属性设置为false
 *              <bean id="user1" class="com.bigDragon.model.User1" scope="prototype"/>  //利用scope属性指定
 *
 * @author bigDragon
 * @create 2020-10-17 15:40
 */
public class SpringBean {

    public int testSingleton(){
        User1 user1 = (User1) SpringContextHolder.getBean("user1");
        return System.identityHashCode(user1);
    }

    public int testPrototype(){
        User5 user5 = (User5)SpringContextHolder.getBean("user5");
        return System.identityHashCode(user5);
    }

    public static void main(String[] args){
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContent.xml");
        User1 user1_test1 = (User1)context1.getBean("user1");
        System.out.println(System.identityHashCode(user1_test1));       //439928219
        User1 user1_test2 = (User1)context1.getBean("user1");
        System.out.println(System.identityHashCode(user1_test2));       //439928219
        User5 user5_test1 = (User5)context1.getBean("user5");
        System.out.println(System.identityHashCode(user5_test1));       //2138564891
        User5 user5_test2 = (User5)context1.getBean("user5");
        System.out.println(System.identityHashCode(user5_test2));       //1151755506
    }
}
