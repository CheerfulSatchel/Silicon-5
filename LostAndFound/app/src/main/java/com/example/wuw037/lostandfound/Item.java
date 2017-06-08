package com.example.wuw037.lostandfound;

/**
 * Created by wuw037 on 6/7/17.
 */

public class Item implements Comparable<Item> {

    public String name;
    public String location;
    public String description;
    public String time;
    public int bounty;
    public boolean isFound;
    public String userID;

    public Item() {
        this.name = "";
        this.location = "";
        this.description = "";
        this.time = "";
        this.bounty = 0;
        this.isFound = false;
        this.userID = "";
    }

    // isFound is true if found, false if lost
    public Item(String name, String location, String description, String time, int bounty, boolean isFound, String userID){
        this.name = name;
        this.location = location;
        this.description = description;
        this.time = time;
        this.bounty = bounty;
        this.isFound = isFound;
        this.userID = userID;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int compareTo(Item item) {
        if(this.getName().equals(item.getName())
                && this.getUserID().equals(item.getUserID())
                && this.getBounty() == item.getBounty()) {
            return 0;
        }
        else
            return -1;
    }


}
