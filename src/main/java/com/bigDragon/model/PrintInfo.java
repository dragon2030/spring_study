package com.bigDragon.model;

/**按bean名称装配
 * @author bigDragon
 * @create 2020-10-16 14:44
 */
public class PrintInfo {
    private User1 user1;

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    @Override
    public String toString() {
        return "PrintInfo{" +
                "user1=" + user1 +
                '}';
    }
}
