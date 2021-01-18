package com.bigDragon.springAOP.simpleAopDemo;

import org.springframework.aop.framework.ProxyFactory;

/**
 * AOP功能中用代码创建代理
 * @author bigDragon
 * @create 2021-01-07 10:36
 */
public class Manger {
    public static void main(String[] args) {
        Target target = new Target();                   //创建目标对象
        ProxyFactory di=new ProxyFactory();
        di.addAdvice(new LoggerExecute());
        di.setTarget(target);
        Target proxy=(Target)di.getProxy();             //创建代理类
        proxy.execute("AOP的简单实现");          //执行execute方法
    }
}
