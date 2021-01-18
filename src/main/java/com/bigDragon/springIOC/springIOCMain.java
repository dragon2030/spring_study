package com.bigDragon.springIOC;

/**
 * Spring核心之IOC
 * @author bigDragon
 * @create 2021-01-07 15:28
 */
public class springIOCMain {
    public static void main(String[] args) {
        //使用BeanFactory管理bean
        new BeanFactoryTest();
        //使用ApplicationContext管理bean
        new ApplicationContextTest();
        //spring IoC依赖注入
        new IoCTest();
        //自动装配
        new AutowireTest();
    }
}
