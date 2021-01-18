package com.bigDragon.springAOP.simpleAopDemo;

/**
 * 被代理的目标对象
 * @author bigDragon
 * @create 2021-01-07 10:18
 */
public class Target {
    //程序执行的方法
    public void execute(String name){
        System.out.println("程序开始执行"+name);
    }
}
