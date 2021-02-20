package com.bigDragon.springIOC;

import com.bigDragon.model.PrintInfo;
import com.bigDragon.model.PrintInfo2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 自动装配
 * <bean>元素的autowire属性负责自动装配<bean>标签定义JavaBean的属性。
 * 一、按bean名称装配
 *      <bean>元素的byName属性以属性名区分自动装配。在容器中寻找与JavaBean的属性名相同的JavaBean，并将其自动装配到JavaBean中。
 * 二、按bean类型装配
 *      <bean>元素的byType属性以属性类型区分自动装配。在容器中寻找与JavaBean的属性类型相同的JavaBean，并将其自动装配到JavaBean中。
 *
 * @author bigDragon
 * @create 2020-10-16 11:27
 */
public class AutowireTest {
    public static void main(String[] args){
        AutowireTest autowireTest = new AutowireTest();
        //1.按bean名称装配
        System.out.println("按bean名称装配");
        autowireTest.autowireByName();
        //2.按bean类型装配
        System.out.println("按bean类型装配");
        autowireTest.autowireByType();
    }

    /**
     * 按bean名称装配：<bean>元素的byname属性以属性名区分自动装配。在容器中寻找与JavaBean的属性名相同的JavaBean，并将其自动装配到JavaBean中。
     *      1.定义bean（PrintInfo），将User1对象注入到bean（PrintInfo）对象中，并在该bean（PrintInfo）中声明输出User1对象属性的方法。
     *      2.在spring的配置文件applicationContext.xml中设置bean的自动装配，Spring将根据bean中的属性名称自动将User1对象注入到指定的bean（PrintInfo）中。
     *      注：如果配置文件中定义了与需要自动装配的JavaBean的名称相同而类型不同的JavaBean，那么它会错误地注入不同类型的JavaBean
     */
    public void autowireByName(){
        Resource resource =  new ClassPathResource("config/applicationContent.xml");   //装载配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        PrintInfo printInfo = (PrintInfo)factory.getBean("printInfo");  //获取bean
        System.out.println(printInfo);
    }

    /**
     * 按bean类型装配：容器会自动寻找与JavaBean的属性类型相同的JavaBean的定义，并将其注入到需要自动装配的JavaBean中。
     *      1.定义bean（PrintInfo2），将User1对象注入到bean（PrintInfo2）对象中，并在该bean（PrintInfo2）中声明输出User1对象属性的方法。
     *      2.在spring的配置文件applicationContext.xml中设置bean的自动装配，Spring将根据bean中的bean类型自动将User1对象注入到指定的bean（PrintInfo2）中。
     *      注：自动装配也会出现无法自动装配的情况，例如在配置文件中再次添加一个User类的实现对象，byType自动装配类型会因为无法自动识别装配哪一个JavaBean而抛出异常。要解决此问题，只能通过
     *      混合使用手动装配来指定装配哪个JavaBean
     */
    public void autowireByType(){
        Resource resource =  new ClassPathResource("config/applicationContent.xml");   //装载配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        PrintInfo2 printInfo2 = (PrintInfo2)factory.getBean("printInfo2");  //获取bean
        System.out.println(printInfo2);
    }
}
