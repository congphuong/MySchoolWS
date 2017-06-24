package com.ashin.DAO;


import com.ashin.connection.MyPool;
import com.ashin.model.Topic;
import org.apache.commons.pool.ObjectPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by trile on 4/16/2017.
 */
public class TopicDAO {

    public int createTopic(Topic t) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "INSERT INTO TOPIC(USERNAME, MA_LOP, THOI_GIAN, CHU_DE, NOI_DUNG, SO_CMT) VALUE(?,?,NOW(),N?,N?,0);";
        int result = 0;
        try {
            int i;
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setString(1, t.getUserID());
            ps.setInt(2, t.getIdClass());
            ps.setString(3, t.getTopicName());
            ps.setString(4, t.getContent());
            i = ps.executeUpdate();
            if (i > 0) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connect != null)
                    pool.returnObject(connect);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int editTopic(Topic tp) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "UPDATE TOPIC SET NOI_DUNG=N?, CHU_DE=N?, THOI_GIAN=NOW() WHERE ID_TOPIC=? AND MA_LOP =?";
        int tmp = 0;

        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setString(1, tp.getContent());
            ps.setString(2, tp.getTopicName());
            ps.setInt(3, tp.getIdTopic());
            ps.setInt(4, tp.getIdClass());
            tmp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connect != null)
                    pool.returnObject(connect);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tmp;
    }

    public int deleteTopic(Topic tp) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "delete from topic where ID_topic=" + tp.getIdTopic();
        int result = 0;

        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connect != null)
                    pool.returnObject(connect);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Topic getATopic(int idClass, int idTopic) {
        Topic topic = null;
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "SELECT * FROM TOPIC WHERE MA_LOP = ? AND ID_TOPIC = ?";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, idClass);
            ps.setInt(2, idTopic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTopicc = rs.getInt(1);
                String username = rs.getString(2);
                int idClasss = rs.getInt(3);
                Date dateTime = rs.getTimestamp(4);
                String topicName = rs.getString(5);
                String context = rs.getString(6);
                int numCmts = rs.getInt(7);
                topic = new Topic(idTopicc, username, idClasss, dateTime, topicName, context, numCmts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connect != null)
                    pool.returnObject(connect);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return topic;
    }

    public int size(int idClass, Connection connection) {
        int result = 0;
        PreparedStatement ps = null;
        String sql = "select count(*) from topic where MA_LOP=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Topic> getTopicPerPage(int idClass, int maxid, int numPerPages) {
        ArrayList<Topic> tps = new ArrayList<>();
        String sql = "";
        Connection connection = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();

        try {
            if (maxid == 0) {
                sql = "SELECT * FROM TOPIC WHERE MA_LOP=" + idClass + " ORDER BY ID_TOPIC DESC LIMIT 0," + numPerPages;
            } else {
                sql = "SELECT * FROM TOPIC WHERE MA_LOP=" + idClass + " and ID_TOPIC < " + maxid + " ORDER BY ID_TOPIC DESC LIMIT 0, " + numPerPages;
            }
            connection = (Connection) pool.borrowObject();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTopic = rs.getInt(1);
                String userID = rs.getString(2);
                int idClasss = rs.getInt(3);
                Date d = rs.getTimestamp(4);
                String topicName = rs.getString(5);
                String content = rs.getString(6);
                int numOfComments = rs.getInt(7);

                tps.add(new Topic(idTopic, userID, idClasss, d, topicName, content, numOfComments));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    pool.returnObject(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tps;
    }

    public static void main(String[] args) {
        TopicDAO t = new TopicDAO();

//        Topic t1 = new Topic("HS001", Calendar.getInstance().getTime(), "XXXXx", "yyyyyyy");
//        int a = t.createTopic(t1);
//        t.setPage(5);
//        System.out.println(t.numPageTopics(1));
//        System.out.println(t.getTopicPerPage(1, 2).size());
//        System.out.println(t.size(1));
//        System.out.println(t.getTopicPerPage(1, 1));
//        System.out.println(t.getTopicsByClass(1).get(1).toString());
    }

}
