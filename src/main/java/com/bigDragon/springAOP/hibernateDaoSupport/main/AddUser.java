package com.bigDragon.springAOP.hibernateDaoSupport.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bigDragon.springAOP.hibernateDaoSupport.dao.UserDAO;
import com.bigDragon.springAOP.hibernateDaoSupport.user.User;

/**
 * @author bigDragon
 * @create 2021-02-02 16:59
 */
//未成功
public class AddUser {
    //添加用户信息
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springAopTestXml/hibernateDaoSupport.xml");
        UserDAO userDAO = (UserDAO)factory.getBean("userDAO");//获取UserDAO
        User user = new User();
        user.setName("郑佳豪");
        user.setAge("26");
        user.setPeople_des("一个可怜人");
        user.setSex_id("男");
        userDAO.insert(user);//执行用户添加的方法
        System.out.println("添加成功！");
    }
}
