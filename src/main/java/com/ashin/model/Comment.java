package com.ashin.model;

/**
 * Created by anluo on 5/25/2017.
 */

import java.sql.Timestamp;

public class Comment {
    private int idCmt;
    private String content;
    private Timestamp time;
    private String userID;
    private int idTopic;

    public Comment() {
    }

    public Comment(String content, Timestamp time, String userID, int idTopic) {
        this.content = content;
        this.time = time;
        this.userID = userID;
        this.idTopic = idTopic;
    }

    public Comment(String content, int idTopic){
        this.content = content;
        this.idTopic = idTopic;
    }

    public Comment(int idCmt, String content, Timestamp time, String userID, int idTopic) {
        this.idCmt = idCmt;
        this.content = content;
        this.time = time;
        this.userID = userID;
        this.idTopic = idTopic;
    }

    public int getIdCmt() {
        return idCmt;
    }

    public void setIdCmt(int idCmt) {
        this.idCmt = idCmt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public boolean isContentNull() {
        if (this.getContent() == "")
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "CommentServer{" +
                "idCmt='" + idCmt + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", userID='" + userID + '\'' +
                ", idTopic='" + idTopic + '\'' +
                '}';
    }


    public void updateComment(int idCmt, String content, Timestamp time, String userID, int idTopic) {
        if (this.idCmt == idCmt && this.userID == userID && this.idTopic == idTopic) {
            this.content = content;
            this.time = time;
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void main(String[] args) {
//        Comment c = new Comment(001, "Đm như lz", Calendar.getInstance().getTime(), "0011", 001);
//        System.out.println(c.toString());
//        c.updateComment(003, "aloalo", Calendar.getInstance().getTime(), "0011", 001);


    }
}
