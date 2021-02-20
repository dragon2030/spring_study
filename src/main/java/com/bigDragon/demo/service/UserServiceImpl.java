package com.bigDragon.demo.service;

import com.bigDragon.demo.dao.userDao;
import com.bigDragon.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bigDragon
 * @create 2021-02-06 11:07
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    userDao userDao;

    public User findById(int userId){
        return userDao.findById(userId);
    }
}
