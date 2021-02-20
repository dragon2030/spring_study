package com.bigDragon.hibernateTest.service;

import com.bigDragon.hibernateTest.dao.UserDao;
import com.bigDragon.hibernateTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bigDragon
 * @create 2021-02-03 14:29
 */
//@Transactional
//@Service
public class UserServiceImpl {
    //@Autowired
    private UserDao userDao;

    public String findBookById(int id)
    {
        return userDao.findUserById(id);
    }
    public void saveBook(User user)
    {
        userDao.saveBook(user);

    }
}
