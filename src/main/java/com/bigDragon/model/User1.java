package com.bigDragon.model;

/**
 * spring bean注入
 *  JavaBean规范
 *      JavaBean 是一种JAVA语言写成的可重用组件。JavaBean符合一定规范编写的Java类，不是一种技术，而是一种规范。
 *      1.JavaBean 类必须是一个公共类，并将其访问属性bai设du置为 public
 *      2.所有属性为private。
 *      3.这个类必须有一个公共的缺省构造函数。即是提供无参数的构造器。
 *      4.这个类的属性使用getter和setter来访问，其他方法遵从标准命名规范。
 *
 * @author bigDragon
 * @create 2020-09-14 14:30
 */
public class User1 {
    private String name;
    private Integer age;
    private String sex;

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

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
