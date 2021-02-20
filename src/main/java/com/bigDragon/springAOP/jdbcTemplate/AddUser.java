package com.bigDragon.springAOP.jdbcTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author bigDragon
 * @create 2021-02-02 14:20
 */
public class AddUser {
    //利用JdbcTemplate添加数据
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springAopTestXml/jdbcTemplate.xml");
        JdbcTemplate jtl =(JdbcTemplate)factory.getBean("jdbcTemplate");//获取JdbcTemplate
        String sql = "insert into user(name,age) values ('小明','23')";//SQL语句
        jtl.update(sql);//执行添加操作
        System.out.println("添加操作执行成功");//输出信息
    }
}
