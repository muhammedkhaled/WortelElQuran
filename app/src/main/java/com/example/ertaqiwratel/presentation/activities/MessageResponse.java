package com.example.ertaqiwratel.presentation.activities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MessageResponse {
    private String userName;
    private String message;
    private String messageTime;
    private String sender;

    public MessageResponse() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageTime() {
        return new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
