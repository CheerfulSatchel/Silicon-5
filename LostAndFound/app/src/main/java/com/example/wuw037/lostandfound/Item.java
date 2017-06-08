package com.example.wuw037.lostandfound;

/**
 * Created by wuw037 on 6/7/17.
 */

public class Item {

    private String name;
    private int bounty;

    public Item(String name, int bounty){
        this.name = name;
        this.bounty = bounty;
    }

    public String getName(){
        return this.name;
    }

    public int getBounty(){
        return this.bounty;
    }

}
