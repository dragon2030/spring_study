package com.bigDragon.springAOP.springDaoSimpleDemo.main;

import com.bigDragon.springAOP.springDaoSimpleDemo.dao.UserDAO;
import com.bigDragon.springAOP.springDaoSimpleDemo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 执行类
 * @author bigDragon
 * @create 2021-01-28 17:01
 */
public class Manger {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("springAopTestXml/springDaoSimpleDemo.xml");////装载配置文件
        User user = new User();//实例化User对象
        user.setName("张三");//设置姓名
        user.setAge("30");//设置年龄
        user.setPeople_des("是个好人");
        user.setSex_id("1");//设置性别
        UserDAO userDAO = (UserDAO) factory.getBean("UserDAOImpl");//获取UserDAO
        userDAO.inserUser(user);//执行添加方法
        System.out.println("数据添加成功!!!");
    }
}
