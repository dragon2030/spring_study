package com.bigDragon.springAOP.classicAopDemo;

/**
 * 经典的基于代理的AOP
 * 参考博客：https://blog.csdn.net/udbnny/article/details/5870076
 * 
 * 这么几个步骤：
 * 1.创建通知：实现这几个接口，把其中的方法实现了
 * 2.定义切点和通知者：在Spring配制文件中配置这些信息
 * 3.使用ProxyFactoryBean来生成代理
 *
 * @author bigDragon
 * @create 2021-01-14 20:39
 */
public class Main {
    public static void main(String[] args) {
        //被代理类的接口类
        Class<Sleepable> sleepableClass = Sleepable.class;
        //被代理类
        Class<Human> humanClass = Human.class;
        //创建通知
        Class<SleepHelper> sleepHelperClass = SleepHelper.class;
        //执行类
        Class<Test> testClass = Test.class;

    }
}
