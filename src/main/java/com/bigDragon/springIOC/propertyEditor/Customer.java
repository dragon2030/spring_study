package com.bigDragon.springIOC.propertyEditor;

import java.util.Date;

/**
 * @author bigDragon
 * @create 2021-01-13 19:19
 */


public class Customer {
    private String name;
    private Address address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
