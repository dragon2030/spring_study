package com.bigDragon.springAOP.declarativeTransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bigDragon
 * @create 2021-02-01 21:08
 */
public class Manger {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springAopTestXml/declarativeTransaction.xml");
        AddDAO addDAO = (AddDAO)factory.getBean("transactionProxy");//获取AddDAO
        User user = new User();//实例化User实体对象
        user.setName("张三");//设置姓名
        user.setAge(30);//设置年龄
        user.setSex_id("男");//设置性别
        addDAO.addUser(user);//执行数据库添加方法
    }
}
