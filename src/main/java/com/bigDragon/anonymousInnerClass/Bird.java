package com.bigDragon.anonymousInnerClass;

/**
 * @author bigDragon
 * @create 2020-09-14 17:19
 */
public abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}