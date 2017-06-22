package com.ashin.DAO;


import com.ashin.model.Connect;
import com.ashin.model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by trile on 4/16/2017.
 */
public class TopicDAO {
    public int numPages;
    private Connect connect = new Connect();

    public void setPage(int numPages) {
        this.numPages = numPages;
    }

    public ArrayList<Topic> getTopics() {
        ArrayList<Topic> listTopics = new ArrayList<Topic>();

        if (listTopics.size() == 0) {
            try {
//                Connection cnt = Connect.open();;
//                Statement stmt = cnt.createStatement();
//                String sql = "select * from topic";
                PreparedStatement ps = connect
                        .getPreparedStatement("select * from topic");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idTopic = rs.getInt(1);
                    String userID = rs.getString(2);
                    int idClass = rs.getInt(3);
                    Date d = rs.getDate(4);
                    String topicName = rs.getString(5);
                    String content = rs.getString(6);
                    int numOfComments = rs.getInt(7);
                    //Comment c = new Comment(idCmt, content, d, userID, idTopic);
                    listTopics.add(new Topic(idTopic, userID, idClass, d, topicName, content, numOfComments));
                }
                ps.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listTopics;
    }

    public ArrayList<Topic> topics = getTopics();

    public int createTopic(Topic t) {
        int result = 0;
//        String sql = "INSERT INTO TOPIC(USERNAME, THOI_GIAN, CHU_DE, NOI_DUNG, SO_CMT) VALUES (?,now(),?,?,0)";
//        Connection cnt = Connect.open();;
        PreparedStatement ps = connect
                .getPreparedStatement("INSERT INTO TOPIC(USERNAME, THOI_GIAN, CHU_DE, NOI_DUNG, SO_CMT) VALUES (?,now(),?,?,0)");
        try {
            int i;
            ps.setString(1, t.getUserID());
            ps.setString(2, t.getTopicName());
            ps.setString(3, t.getContent());
            i = ps.executeUpdate();
            if (i > 0) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        connect.close();
        return result;
    }

    public ArrayList<Topic> getTopicsByClass(int idClass) {
        String sql = "SELECT * FROM project.topic WHERE topic.MA_LOP=?";
        PreparedStatement ps = connect.getPreparedStatement(sql);
        ArrayList<Topic> topics = new ArrayList<>();

        try {
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTopic = rs.getInt(1);
                String userID = rs.getString(2);
                int idClasss = rs.getInt(3);
                Date d = rs.getDate(4);
                String topicName = rs.getString(5);
                String content = rs.getString(6);
                int numOfComments = rs.getInt(7);
                //Comment c = new Comment(idCmt, content, d, userID, idTopic);
                topics.add(new Topic(idTopic, userID, idClasss, d, topicName, content, numOfComments));
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topics;
    }


    public int editTopic(Topic tp) {
        int tmp = 0;
        PreparedStatement ps = connect
                .getPreparedStatement("UPDATE TOPIC SET NOI_DUNG=?, CHU_DE=?, THOI_GIAN=NOW() WHERE ID_TOPIC=?");

        try {
            ps.setString(1, tp.getContent());
            ps.setString(2, tp.getTopicName());
            ps.setInt(3, tp.getIdTopic());
            for (int i = 0; i < topics.size(); i++) {
                if (tp.getIdTopic() == topics.get(i).getIdTopic() && tp.getUserID().equals(topics.get(i).getUserID())) {
                    tmp = ps.executeUpdate();
                    break;
                }
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public Topic deleteTopic(Topic tp) {
        Topic topic = null;
        PreparedStatement ps = connect
                .getPreparedStatement("delete from topic where ID_topic=" + tp.getIdTopic());
        try {
            for (int i = 0; i < topics.size(); i++) {
                if (tp.getIdTopic() == topics.get(i).getIdTopic()) {
                    topic = topics.remove(i);
                    ps.executeUpdate();
                    break;
                }
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topic;
    }

    public Topic getATopic(int id) {
        Topic topic = null;
        for (Topic t : topics) {
            if (t.getIdTopic() == id) {
                topic = t;
                break;
            }
        }

        return topic;
    }

    public int size(int idClass) {
        ArrayList<Topic> tps = new ArrayList<>();
        for (int i = 0; i < topics.size(); i++) {
            if (idClass == topics.get(i).getIdClass()) {
                tps.add(topics.get(i));
            }
        }
        return tps.size();
    }

    public int numPageTopics(int idClass) {
        int result = 0;
        result = size(idClass) / numPages;
        if (size(idClass) % numPages != 0) {
            result++;
        }
        return result;
    }

    public ArrayList<Topic> getTopicPerPage(int idClass, int page) {
        ArrayList<Topic> tps = new ArrayList<>();
        String sql = "";
        if (page > numPageTopics(idClass)) {
            page = numPageTopics(idClass);
        }
        sql = "SELECT * FROM TOPIC WHERE TOPIC.MA_LOP = ? LIMIT " + (page - 1) * this.numPages + "," + this.numPages;

        try {
            PreparedStatement ps = connect.getPreparedStatement(sql);
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTopic = rs.getInt(1);
                String userID = rs.getString(2);
                int idClasss = rs.getInt(3);
                Date d = rs.getDate(4);
                String topicName = rs.getString(5);
                String content = rs.getString(6);
                int numOfComments = rs.getInt(7);

                tps.add(new Topic(idTopic, userID, idClasss, d, topicName, content, numOfComments));
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tps;
    }

    public static void main(String[] args) {
        TopicDAO t = new TopicDAO();

//        Topic t1 = new Topic("HS001", Calendar.getInstance().getTime(), "XXXXx", "yyyyyyy");
//        int a = t.createTopic(t1);
        t.setPage(5);
        System.out.println(t.numPageTopics(1));
        System.out.println(t.getTopicPerPage(1, 2).size());
//        System.out.println(t.size(1));
//        System.out.println(t.getTopicPerPage(1, 1));
//        System.out.println(t.getTopicsByClass(1).get(1).toString());
    }

}
