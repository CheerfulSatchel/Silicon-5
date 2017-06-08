package com.example.wuw037.lostandfound;

/**
 * Created by vff806 on 6/7/17.
 */

public class User {
    public String name;
    public String email;
    public String pass;
    public String phoneNum;

    public User(String name, String email, String pass, String phoneNum) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() { return this.email; }

    public String getPass() {
        return this.pass;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
}
