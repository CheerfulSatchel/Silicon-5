package com.example.wuw037.lostandfound;

/**
 * Created by vff806 on 6/8/17.
 */

public class Message {
    private String senderID;
    private String recvrID;
    private String itemID;
    private String messageBody;

    public Message(String senderID, String recvrID, String itemID, String messageBody) {
        this.senderID = senderID;
        this.recvrID = recvrID;
        this.itemID = itemID;
        this.messageBody = messageBody.substring(0, 140);
    }

    public String getSenderID() {
        return this.senderID;
    }

    public String getRecvrID() {
        return recvrID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getMessageBody() {
        return messageBody;
    }
}
