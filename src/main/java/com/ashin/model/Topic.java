package com.ashin.model;

import com.ashin.DAO.CommentDAO;

import java.util.ArrayList;
import java.util.Date;

public class Topic {
    private int idTopic;
    private String userID;
    private int idClass;
    private Date time;
    private String topicName;
    private String content;
    private int numCMT;

    public Topic() {
    }

    public Topic(String userID, int idClass, Date time, String topicName, String content, int numCMT) {
        this.userID = userID;
        this.idClass = idClass;
        this.time = time;
        this.topicName = topicName;
        this.content = content;
        this.numCMT = numCMT;
    }

    public Topic(int idTopic, String userID, int idClass, Date time, String topicName, String content, int numCMT) {
        this.idTopic = idTopic;
        this.userID = userID;
        this.idClass = idClass;
        this.time = time;
        this.topicName = topicName;
        this.content = content;
        this.numCMT = numCMT;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void numOfComment() {

    }


    public int getNumCMT() {
        return numCMT;
    }

    public void setNumCMT(int numCMT) {
        this.numCMT = numCMT;
    }

    public void updateTopic(int idTopic, String userID, Date time, String topicName, String content) {
        if (this.idTopic == idTopic && this.userID == userID) {
            this.time = time;
            this.topicName = topicName;
            this.content = content;
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                "idTopic=" + idTopic +
                ", userID='" + userID + '\'' +
                ", idClass=" + idClass +
                ", time=" + time +
                ", topicName='" + topicName + '\'' +
                ", content='" + content + '\'' +
                ", numCMT=" + numCMT +
                '}';
    }
}
