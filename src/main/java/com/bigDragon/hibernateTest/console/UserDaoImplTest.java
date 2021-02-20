package com.bigDragon.hibernateTest.console;

import com.bigDragon.hibernateTest.model.User;
import com.bigDragon.hibernateTest.service.UserService;
import com.bigDragon.hibernateTest.service.UserServiceImpl;
import com.bigDragon.springAOP.hibernateDaoSupport.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @author bigDragon
 * @create 2021-02-03 14:42
 */
public class UserDaoImplTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate/hibernateTest.xml");
        //UserDAO userDAO = (UserDAO)factory.getBean("userDAO");//获取UserDAO
        UserServiceImpl userService=applicationContext.getBean(UserServiceImpl.class);
        //UserService bookService=factory.getBean(UserService.class);
        User user = new User();
        user.setName("郑佳豪");
        user.setAge("26");
        user.setPeopleDes("一个可怜人2");
        user.setSexId("男");
        user.setCreateTime(new Date());
        userService.saveBook(user);
        System.out.println("添加成功！");
        String bookById = userService.findBookById(1);
        System.out.println(bookById);
    }
}

