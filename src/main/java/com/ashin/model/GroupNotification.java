package com.ashin.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by anluo on 6/22/2017.
 */
public class GroupNotification {
    private int id;
    private String noti;
    private String sender;
    private List<String> receiver;
    private String title;
    private Timestamp date;

    public GroupNotification(int id, String sender,List<String> receiver, String title, String noti, Timestamp date) {
        this.id = id;
        this.noti = noti;
        this.sender = sender;
        this.date = date;
        this.receiver = receiver;
        this.title = title;
    }

    public GroupNotification(String sender,List<String> receiver, String title, String noti, Timestamp date) {
        this.noti = noti;
        this.sender = sender;
        this.date = date;
        this.receiver = receiver;
        this.title = title;
    }

    public GroupNotification() {
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

    public List<String> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<String> receiver) {
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
