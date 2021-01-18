package com.bigDragon.springAOP.simpleAopDemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 拦截目标对象的方法
 * @author bigDragon
 * @create 2021-01-07 10:29
 */
public class LoggerExecute implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        invocation.proceed();
        after();
        return null;
    }

    //前置通知
    private void before() {
        System.out.println("程序开始执行之前");
    }
    //前置通知
    private void after() {
        System.out.println("程序开始执行之后");
    }
}
