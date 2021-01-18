package com.bigDragon.springAOP.classicAopDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 执行类
 * @author bigDragon
 * @create 2021-01-14 20:54
 */
public class Test {

    public static void main(String[] args){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("classicAopDemo.xml");
/*        Sleepable sleeper = (Sleepable)appCtx.getBean("humanProxy");*/
        //方法二：
        Sleepable sleeper = (Sleepable)appCtx.getBean("human");
        sleeper.sleep();
    }
}
