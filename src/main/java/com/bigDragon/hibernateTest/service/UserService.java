package com.bigDragon.hibernateTest.service;

import com.bigDragon.hibernateTest.model.User;
import org.springframework.stereotype.Service;

/**
 * @author bigDragon
 * @create 2021-02-03 14:28
 */

public interface UserService {
    public String findUserById(int id);
    public void saveBook(User user);
}
