package com.bigDragon.controller.springIOC;

import com.bigDragon.model.User1;
import com.bigDragon.model.User2;
import com.bigDragon.model.User3;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * spring IoC依赖注入
 *
 * 一、控制反转与依赖注入
 *
 * 参考博客：https://blog.csdn.net/sinat_21843047/article/details/80297951
 *
 *  控制反转：IoC（Inversion of Control）,即控制反转。它使程序组件或类之间尽量形成一种松耦合的结构，开发者
 *      使用类的实例之前，需要先创建对象的实例。但是IoC将创建实例的任务交给IoC容器，这样开发应用代码时只需要
 *      直接使用类的实例，这就是IoC。通常用一个所谓的好莱坞原则（“Don not call me,I will call you.”）来
 *      比喻这种控制反转的关系。
 *
 *  依赖注入：DI（Dependency Injection）的三种实现类型，Spring支持后两种。
 *      接口注入：基于接口将调用与实现分离。这种依赖注入方式必须实现容器所规定的接口，使程序代码和容器API绑定
 *          在一起，并不是理想的依赖注入方式。
 *      Setter注入：基于JavaBean的Setter()方法为属性赋值。在实际开发中得到了最广泛的应用.
 *      构造器注入：基于构造器方法为属性赋值。容器通过调用类的构造器方法，将其所需要的依赖关系注入其中。
 *
 *  引入其他的bean
 *      在Spring中可以通过配置文件中使用<ref>元素引用其他的JavaBean的实例对象
 *  二、bean的配置
 *      想要在Spring IoC容器中获取一个bean，首先要配置文件的<beans>元素中配置一个子元素<bean>,Spring的控制
 *          反转机制会根基<bean>元素的具体配置来实例化这个bean实例。
 *      例：<bean id="test" class="com.mr.Test"/>
 *      其中，id属性为bean的名称，class属性为对应的类名，这样通过BeanFactory容器的getBean("")方法就可以获取
 *      该类的实例。
 *
 * @author bigDragon
 * @create 2020-09-14 13:39
 */
public class IoCTest {
    public static void main(String[] args){
        IoCTest ioCTest = new IoCTest();
        //spring IoC 依赖注入方式一：setter注入
        //ioCTest.setterInjection();
        //spring IoC 依赖注入方式二：构造器注入
        //ioCTest.constructorInjection();

        //引入其他的bean
        ioCTest.otherBeanInjection();
    }

    /**
     * spring IoC 依赖注入方式一：setter注入
     */
    public void setterInjection(){
        Resource resource = new ClassPathResource("applicationContent.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User1 user1 = (User1) beanFactory.getBean("user1");
        System.out.println(user1.toString());
    }

    /**
     * spring IoC 依赖注入方式二：构造器注入
     */
    public void constructorInjection(){
        Resource resource = new ClassPathResource("applicationContent.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User2 user2 = (User2) beanFactory.getBean("user2");
        System.out.println(user2.toString());
    }

    /**
     * 引入其他的bean
     */
    public void otherBeanInjection(){
        Resource resource = new ClassPathResource("applicationContent.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User3 user3 = (User3) beanFactory.getBean("user3");
        System.out.println(user3.toString());
    }

}
