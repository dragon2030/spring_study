package com.bigDragon.springAOP.classicAopDemo;

/**
 * 被代理类
 * @author bigDragon
 * @create 2021-01-14 20:36
 */
public class Human implements Sleepable{


    public void sleep(){
        System.out.println("睡觉了！梦中自有颜如玉！");
    }

}