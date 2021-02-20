package com.bigDragon.hibernateTest.dao;

import com.bigDragon.hibernateTest.model.User;

/**
 * @author bigDragon
 * @create 2021-02-03 14:05
 */
public interface UserDao {
    public String findUserById(int id);

    public void saveBook(User user);
}
