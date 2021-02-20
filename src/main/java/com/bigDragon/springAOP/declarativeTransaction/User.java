package com.bigDragon.springAOP.declarativeTransaction;

/**
 * @author bigDragon
 * @create 2021-02-01 21:08
 */
public class User {

    private String name;//姓名

    private Integer age;//年龄

    private String sex_id;//性别

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

    public String getSex_id() {
        return sex_id;
    }

    public void setSex_id(String sex_id) {
        this.sex_id = sex_id;
    }
}
