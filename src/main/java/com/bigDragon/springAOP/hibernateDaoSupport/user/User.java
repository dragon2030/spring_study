package com.bigDragon.springAOP.hibernateDaoSupport.user;

import javax.persistence.Entity;

/**
 * @author bigDragon
 * @create 2021-02-03 11:37
 */
public class User {
    private int user_id;
    private String name;
    private String age;
    private String people_des;
    private String sex_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getPeople_des() {
        return people_des;
    }

    public void setPeople_des(String people_des) {
        this.people_des = people_des;
    }

    public String getSex_id() {
        return sex_id;
    }

    public void setSex_id(String sex_id) {
        this.sex_id = sex_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", people_des='" + people_des + '\'' +
                ", sex_id='" + sex_id + '\'' +
                '}';
    }
}
