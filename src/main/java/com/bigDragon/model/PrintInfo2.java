package com.bigDragon.model;

/**
 * 按照bean类型装配
 * @author bigDragon
 * @create 2020-10-17 15:12
 */
public class PrintInfo2 {
    private User1 user;

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PrintInfo2{" +
                "user=" + user +
                '}';
    }
}
