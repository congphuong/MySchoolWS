package com.ashin.model;

/**
 * Created by anluo on 6/3/2017.
 */

import java.sql.Timestamp;


public class Notification {
    private int id;
    private String noti;
    private String sender;
    private String receiver;
    private String title;
    private Timestamp date;

    public Notification(int id, String sender, String receiver, String title, String noti, Timestamp date) {
        this.id = id;
        this.noti = noti;
        this.sender = sender;
        this.date = date;
        this.receiver = receiver;
        this.title = title;
    }

    public Notification(String sender, String receiver, String title, String noti) {
        this.noti = noti;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
    }

    public Notification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoti() {
        return noti;
    }

    public void setNoti(String noti) {
        this.noti = noti;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

