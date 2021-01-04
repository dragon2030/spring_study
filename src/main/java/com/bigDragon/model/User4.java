package com.bigDragon.model;

/**
 * @author bigDragon
 * @create 2020-09-14 17:00
 */
public abstract class User4 {
    private String name;
    private Integer age;
    private String sex;

    @Override
    public String toString() {
        return "User4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
