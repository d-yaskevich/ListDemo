package com.example.listdemo.models;

import androidx.annotation.DrawableRes;

import com.example.listdemo.R;

import java.util.ArrayList;

public class User extends UserListItem {
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
        if (avatarRes == -1) return R.color.colorAccent;
        else return avatarRes;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    private static String[] names = new String[]{"Ivan Ivanov", "Alex Alex", "Pavel Pavel", "Fedor Fedor", "David David", "Sam Sam", "Name Name"};
    private static int[] avatars = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6};

    public static ArrayList<User> getUsers(int count) {
        final ArrayList<User> users = new ArrayList<>();

//        for(String name: names)
        for (int i = 0; i < count; i++) { // i = i + 1
            User user;

            String name = "Name #" + (i + 1);
            if (i < names.length) {
                name = names[i];
            }
            if (i < avatars.length) {
                int avatarRes = avatars[i];

                user = new User(avatarRes, name, i + 20);
            } else {
                user = new User(name, i + 20);
            }

            users.add(user);
        }

        return users;
    }
}
