package com.bigDragon;

import java.util.Date;

/**
 * 测试实验类
 * @author bigDragon
 * @create 2020-09-30 9:28
 */
public class TestMain {
    public static void main(String[] args){
        new TestMain().test();
    }

    @Deprecated
    public void test(){
        Date date = new Date("2020/10/10");
        System.out.println(date);
    }
}
