package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Comment;
import com.ashin.model.Connect;
import org.apache.commons.pool.ObjectPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by trile on 4/16/2017.
 */
public class CommentDAO {
    public int numPages;
    private Connect connect = new Connect();

    public void setPages(int numPages) {
        this.numPages = numPages;
    }

    public int addComment1(Comment c) {
//        String sql = "insert into cmt(ID_TOPIC, USERNAME, NOI_DUNG, THOI_GIAN) values(?,?,?,now());";
//        Connection cnt = Connect.open();;
        PreparedStatement ps = connect
                .getPreparedStatement("insert into cmt(ID_TOPIC, USERNAME, NOI_DUNG) values(?,?,?)");
        int result = 0;
        try {
            int i;
//            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setInt(1, c.getIdTopic());
            ps.setString(2, c.getUserID());
            ps.setString(3, c.getContent());
            i = ps.executeUpdate();
            if (i > 0) {
                result = 1;
            }
            ps.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int editComment(Comment c) throws SQLException {
//        String sql = "UPDATE CMT SET NOI_DUNG=?, THOI_GIAN= NOW() WHERE CMT.ID_CMT =?";
//        Connection cnt = Connect.open();;

        PreparedStatement ps = connect
                .getPreparedStatement("UPDATE CMT SET NOI_DUNG=?, THOI_GIAN= NOW() WHERE CMT.ID_CMT =?");
        int tmp = 0;
//        PreparedStatement stmt = cnt.prepareStatement(sql);
        ps.setString(1, c.getContent());
        ps.setInt(2, c.getIdCmt());

                tmp = ps.executeUpdate();



        return tmp;
    }

    public int size(int idTopic, Connection connection) {
        int result =0;
        PreparedStatement ps = null;
        try {
            ps = connection
                    .prepareStatement("select count(*) from CMT where ID_TOPIC=?");
            ps.setInt(1,idTopic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Comment deleteComment(Comment comment) throws SQLException {
        Comment c = null;
//        Connection cnt = Connect.open();;
//        Statement stmt = cnt.createStatement();
//        String sql = "delete from cmt where ID_CMT=" + comment.getIdCmt();
        PreparedStatement ps = connect
                .getPreparedStatement("delete from cmt where ID_CMT=" + comment.getIdCmt());

                ps.execute();
                connect.close();
        return c;
    }

    public ArrayList<Comment> getCommentPerOffset(int idTp, int offset) {
        Connection cnt = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            cnt = (Connection) pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement stmt = null;
        String sql = "";
//        String sql = "SELECT * FROM CMT WHERE CMT.ID_TOPIC = "+ idTp +" LIMIT "+(page-1)*numPages+","+numPages;
        ArrayList<Comment> cmts = new ArrayList<>();

        if (offset==size(idTp, cnt)){
            try {
                pool.returnObject(cnt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cmts;
        }

        sql = "SELECT * FROM CMT WHERE CMT.ID_TOPIC = " + idTp + " LIMIT " + offset + "," + numPages;

        try {
            stmt = cnt.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idCmt = rs.getInt(1);
                int idTopic = rs.getInt(2);
                String userID = rs.getString(3);
                String content = rs.getString(4);
                Timestamp d = rs.getTimestamp(5);
                cmts.add(new Comment(idCmt, content, d, userID, idTopic));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null)
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(cnt!=null)
                pool.returnObject(cnt);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cmts;
    }

    public static void main(String[] args) throws SQLException {
        CommentDAO c = new CommentDAO();
        c.setPages(5);
        System.out.println(c.getCommentPerOffset(1,5));
        Connection connection = c.connect.open();
        connection.close();
        System.out.println(connection.isClosed());
    }
}
