package com.example.listdemo.models;

import java.util.ArrayList;
import java.util.Random;

public class Banner extends UserListItem {
    public static ArrayList<Integer> getBannerIndexes(int size) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size / 4; i++) {
            int index = random.nextInt(size);
            list.add(index);
        }

        return list;
    }

    public static ArrayList<UserListItem> getBannerUserList(ArrayList<User> users){
        ArrayList<UserListItem> list = new ArrayList<>();
        list.addAll(users);
        ArrayList<Integer> bannerIndex = Banner.getBannerIndexes(users.size());
        for (int index : bannerIndex) {
            list.add(index, new Banner());
        }
        return list;
    }


    @Override
    public String toString() {
        return "BANNER";
    }
}
