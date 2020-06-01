package com.example.listdemo;

import androidx.annotation.DrawableRes;

public class User extends Object {
    @DrawableRes
    private int avatarRes = -1;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(int avatarRes, String name, int age) {
        this.avatarRes = avatarRes;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAvatarRes() {
        if(avatarRes == -1) return R.color.colorAccent;
        else return avatarRes;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
