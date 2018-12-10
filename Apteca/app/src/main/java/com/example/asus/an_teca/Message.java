package com.example.asus.an_teca;

/**
 * Created by ASUS on 30/11/2017.
 */

public class Message {
    private String message,user_name;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public Message() {
    }
    public Message(String message, String user_name) {
        this.message = message;
        this.user_name = user_name;
    }

}


