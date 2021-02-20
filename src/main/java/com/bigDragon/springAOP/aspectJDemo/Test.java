package com.bigDragon.springAOP.aspectJDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bigDragon
 * @create 2021-01-18 17:31
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("springAopTestXml/aspectjDemo.xml");
        Sleepable human = (Sleepable)appCtx.getBean("human");
        //human.sleep("12345");
        //产生异常测试
        human.sleep("123");
    }
}
