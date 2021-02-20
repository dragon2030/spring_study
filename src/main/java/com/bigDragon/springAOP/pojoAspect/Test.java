package com.bigDragon.springAOP.pojoAspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bigDragon
 * @create 2021-01-20 12:14
 */
public class Test {
    public static void main(String[] args) {
        String xm=null;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springAopTestXml/pojoAspect.xml");
        SleepDao sleep = (SleepDao) context.getBean("sleep");
        try {
            xm = sleep.sleep("xm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(xm);
    }
}
