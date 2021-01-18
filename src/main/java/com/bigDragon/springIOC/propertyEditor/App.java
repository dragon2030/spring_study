package com.bigDragon.springIOC.propertyEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义属性编辑器（异常未解决）
 * @author bigDragon
 * @create 2021-01-13 19:19
 */
public class App
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("propertyEditor.xml");
        Customer c = ctx.getBean("customer", Customer.class);

        //输出
        System.out.println(c.getAddress().toString());

    }
}