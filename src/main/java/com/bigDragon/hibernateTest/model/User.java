package com.bigDragon.hibernateTest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * @author bigDragon
 * @create 2021-02-04 17:07
 */
@Entity
@Table(name = "user")
public class User {
    private int userId;
    private String name;
    private String age;
    private String peopleDes;
    private String sexId;
    private Date createTime;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "people_des")
    public String getPeopleDes() {
        return peopleDes;
    }

    public void setPeopleDes(String peopleDes) {
        this.peopleDes = peopleDes;
    }

    @Basic
    @Column(name = "sex_id")
    public String getSexId() {
        return sexId;
    }

    public void setSexId(String sexId) {
        this.sexId = sexId;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(peopleDes, user.peopleDes) &&
                Objects.equals(sexId, user.sexId) &&
                Objects.equals(createTime, user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, age, peopleDes, sexId, createTime);
    }
}
