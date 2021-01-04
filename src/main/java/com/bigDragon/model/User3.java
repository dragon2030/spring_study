package com.bigDragon.model;

/**
 * @author bigDragon
 * @create 2020-09-14 16:22
 */
public class User3 {
    private User1 user1;

    @Override
    public String toString() {
        return "User3{" +
                "user1=" + user1 +
                '}';
    }

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }
}
