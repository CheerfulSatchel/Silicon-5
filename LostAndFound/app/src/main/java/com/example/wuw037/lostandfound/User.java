package com.example.wuw037.lostandfound;

/**
 * Created by vff806 on 6/7/17.
 */

public class User {
    private String name;
    private String pass;
    private String phoneNum;

    public User(String name, String pass, String phoneNum) {
        this.name = name;
        this.pass = pass;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public String getPass() {
        return this.pass;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
}
