package com.bigDragon.springAOP.pojoAspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author bigDragon
 * @create 2021-01-20 12:16
 */
public class SleepAspect {
    public void before(){
        System.out.println("睡觉之前拖衣服");
    }
    public void afterReturning(){
        System.out.println("睡觉");
    }
    public void afterThrowing(Exception ex) throws Exception {
        System.out.println("出大事了,有bug");
        System.out.println(ex.getMessage());
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object proceed =null;
        if (!"".equals("admin")){
            System.out.println("核心方法被执行");
            proceed = pjp.proceed(pjp.getArgs());
            System.out.println("核心方法执行完");
         }
        return proceed;
        }
}
