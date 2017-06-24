package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Comment;
import org.apache.commons.pool.ObjectPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by trile on 4/16/2017.
 */
public class CommentDAO {
    private int numPages;

    public void setPages(int numPages) {
        this.numPages = numPages;
    }

    public int addComment1(Comment c) {
        Connection connect = null;
        PreparedStatement ps = null;
        String sql = "insert into cmt(ID_TOPIC,USERNAME,NOI_DUNG) values(?,?,N?)";
        ObjectPool pool = MyPool.getInstance();
        int result = 0;
        try {
            int i;
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, c.getIdTopic());
            ps.setString(2, c.getUserID());
            ps.setString(3, c.getContent());
            i = ps.executeUpdate();
            if (i > 0) {
                result = 1;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }finally {
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

    public int editComment(Comment c) throws SQLException {
        Connection connect = null;
        PreparedStatement ps = null;
        String sql = "UPDATE CMT SET NOI_DUNG=N?, THOI_GIAN= NOW() WHERE CMT.ID_CMT =?";
        ObjectPool pool = MyPool.getInstance();
        int tmp = 0;
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setString(1, c.getContent());
            ps.setInt(2, c.getIdCmt());
            tmp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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

    public int size(int idTopic, Connection connection) {
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = connection
                    .prepareStatement("select count(*) from CMT where ID_TOPIC=?");
            ps.setInt(1, idTopic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
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

    public Comment deleteComment(Comment comment) throws SQLException {
        Comment c = null;
        Connection connect = null;
        PreparedStatement stmt = null;
        String sql = "delete from cmt where ID_CMT=" + comment.getIdCmt() + ";";
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            stmt = connect.prepareStatement(sql);
            stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
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
        return c;
    }

    public ArrayList<Comment> getCommentPerOffset(int idTp, int offset) {
        Connection connect = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement stmt = null;
        String sql = "";
        ArrayList<Comment> cmts = new ArrayList<>();
        if (offset == size(idTp, connect)) {
            try {
                pool.returnObject(connect);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cmts;
        }
        sql = "SELECT * FROM CMT WHERE CMT.ID_TOPIC = " + idTp + " LIMIT " + offset + "," + numPages;
        try {
            stmt = connect.prepareStatement(sql);
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
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
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
        return cmts;
    }

    public static void main(String[] args) throws SQLException {
        CommentDAO c = new CommentDAO();
        c.setPages(5);
        System.out.println(c.getCommentPerOffset(1, 5));

    }
}
