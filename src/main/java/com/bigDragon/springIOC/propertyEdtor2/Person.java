package com.bigDragon.springIOC.propertyEdtor2;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 人员 Person pojo类
 * @author bigDragon
 * @create 2021-01-18 16:37
 */


public class Person {

    private int id;
    private String name;
    private Education education;


    private Date dataValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
