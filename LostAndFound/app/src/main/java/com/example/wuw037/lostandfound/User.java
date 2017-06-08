package com.example.wuw037.lostandfound;

/**
 * Created by vff806 on 6/7/17.
 */

public class User {
    private String name;
    private String phoneNum;

    public User(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone_num() {
        return this.phoneNum;
    }
    
}
