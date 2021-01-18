package com.bigDragon.springAOP.classicAopDemo;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 创建通知
 * @author bigDragon
 * @create 2021-01-14 20:45
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    public void before(Method mtd, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("通常情况下睡觉之前要脱衣服！");
    }

    public void afterReturning(Object arg0, Method arg1, Object[] arg2,
                               Object arg3) throws Throwable {
        System.out.println("起床后要先穿衣服！");
    }

}
