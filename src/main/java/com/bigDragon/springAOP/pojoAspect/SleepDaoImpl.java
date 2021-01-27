package com.bigDragon.springAOP.pojoAspect;


/**
 * 被代理类
 * @author bigDragon
 * @create 2021-01-14 20:36
 */
public class SleepDaoImpl implements SleepDao{

    @Override
    public String sleep(String name) throws Exception {
        if (!name.equals("xm")){
            throw new Exception("睡你妹啊,起来嗨杯");
        }
        System.out.println("开始睡觉");
        return "小明";
        }

}