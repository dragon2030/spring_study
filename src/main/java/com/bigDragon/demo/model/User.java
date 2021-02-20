package com.bigDragon.demo.model;

import java.util.Date;

/**
 * @author bigDragon
 * @create 2021-02-06 11:02
 */
public class User {
    private int userId;
    private String name;
    private String age;
    private String peopleDes;
    private String sex;
    private Date createTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPeopleDes() {
        return peopleDes;
    }

    public void setPeopleDes(String peopleDes) {
        this.peopleDes = peopleDes;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", peopleDes='" + peopleDes + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
