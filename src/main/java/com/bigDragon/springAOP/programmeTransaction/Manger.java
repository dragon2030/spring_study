package com.bigDragon.springAOP.programmeTransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 失败样例：
 * 操作执行失败，事务回滚！
 * 原因：Unknown column 'sex' in 'field list'
 *
 * @author bigDragon
 * @create 2021-02-01 20:29
 */
public class Manger {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springAopTestXml/programmeTransaction.xml");
        TransactionExample transactionExample = (TransactionExample) factory.getBean("transactionExample");//获取UserDAO
        transactionExample.transactionOperation();//执行添加方法
    }
}
