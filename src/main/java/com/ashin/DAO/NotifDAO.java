package com.ashin.DAO;

/**
 * Created by anluo on 6/3/2017.
 */

import com.ashin.connection.MyPool;
import com.ashin.controller.PushNotification;
import com.ashin.model.GroupNotification;
import com.ashin.model.Notification;
import org.apache.commons.pool.ObjectPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotifDAO {
    int numberPerPage = 10;
    PushNotification pn = new PushNotification();

    public void insert(Notification notif) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "insert into THONGBAO(ID_TB,NGUOIGUI,NGUOINHAN,TIEU_DE,NOI_DUNG,THOI_GIAN) values(?,?,?,N?,N?,?)";

        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, notif.getId());
            ps.setString(2, notif.getSender());
            ps.setString(3, notif.getReceiver());
            ps.setString(4, notif.getTitle());
            ps.setString(5, notif.getNoti());
            ps.setTimestamp(6, notif.getDate());
            ps.executeUpdate();
            pn.sendNotification(notif);

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
    }

    public void insertGroup(GroupNotification grnotif) {
        String sql = "insert into THONGBAO(ID_TB,NGUOIGUI,NGUOINHAN,TIEU_DE,NOI_DUNG,THOI_GIAN) values(?,?,?,N?,N?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connection = (Connection) pool.borrowObject();
            Notification no = new Notification();
            int temp = grnotif.getId();
            for (int i = 0; i < grnotif.getReceiver().size(); i++) {
                no = new Notification(grnotif.getSender(), grnotif.getReceiver().get(i), grnotif.getTitle(), grnotif.getNoti(), grnotif.getDate());
                ps = connection.prepareStatement(sql);
                ps.setInt(1, no.getId());
                ps.setString(2, no.getSender());
                ps.setString(3, no.getReceiver());
                ps.setString(4, no.getTitle());
                ps.setString(5, no.getNoti());
                ps.setTimestamp(6, no.getDate());
                ps.executeUpdate();
                pn.sendNotification(no);
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
                if (connection != null)
                    pool.returnObject(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Notification view(int idno) {
        String sql = "SELECT * from THONGBAO where ID_TB=?";
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            Notification no = new Notification();
            ps.setInt(1, idno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                no.setId(rs.getInt(1));
                no.setSender(rs.getString(2));
                no.setReceiver(rs.getString(3));
                no.setTitle(rs.getString(4));
                no.setNoti(rs.getString(5));
                no.setDate(rs.getTimestamp(6));
            }
            ps.close();
            return no;
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
        return null;
    }

    public int sizeByReceiver(String receiver) {
        String sql = "select count(*) from THONGBAO where NGUOINHAN=?";
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        int result = 0;
        try {
            Notification no = new Notification();
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setString(1, receiver);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
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

    public int sizeBySender(String sender) {
        String sql = "select count(*) from THONGBAO where NGUOIGUI=?";
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        int result = 0;
        try {
            connect = (Connection) pool.borrowObject();
            Notification no = new Notification();
            ps = connect.prepareStatement(sql);
            ps.setString(1, sender);
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

    public void update(int idNotif, Notification input) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        String sql = "update THONGBAO set NOI_DUNG=N? where ID_TB='" + idNotif + "'";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement(sql);
            ps.setString(1, input.getNoti());
            ps.executeUpdate();
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
    }

    public List<Notification> loadNotifPerPageReceiver(int maxid, int numPerPage, String receiver) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();

        List<Notification> ln = new ArrayList<>();
        try {
            String sql = "";
            if (maxid == 0) {
                sql = "SELECT * FROM THONGBAO WHERE NGUOINHAN='" + receiver + "'" + " order by ID_TB DESC LIMIT 0," + numPerPage;
            } else {
                sql = "SELECT * FROM THONGBAO WHERE NGUOINHAN='" + receiver + "'" + " and ID_TB < " + maxid + " order by ID_TB DESC LIMIT 0," + numPerPage;
            }
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            rs.close();
            ps.close();
            return ln;
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

        return ln;
    }

    public List<Notification> loadNotifPerPageSender(int page, int numPerPage, String sender) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();

        try {
            List<Notification> ln = new ArrayList<>();
            NotifDAO nd = new NotifDAO();
            Notification no = new Notification();
            int temp = nd.sizeBySender(sender);
            String sql = "";
            if (page * numPerPage > temp) {
                return null;
            }
            if (page == pageNum(numPerPage, temp)) {
                sql = "SELECT * FROM THONGBAO" + " WHERE NGUOIGUI='" + sender + "'" + "LIMIT 0," + temp % numPerPage;
                System.out.println(sql + "tren");
            } else {
                sql = "SELECT * FROM THONGBAO " + " WHERE NGUOIGUI='" + sender + "'" + " LIMIT " + (temp - page * numPerPage) + "," + numPerPage;
                System.out.println(sql);
            }
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            ps.close();
            rs.close();
            return ln;
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
        return null;
    }

    public static int pageNum(int numberPerPage, int input) {
        int result = 0;
        result = input / numberPerPage;
        if (input % numberPerPage != 0) {
            result++;
        }
        System.out.println("Page num" + result);
        return result;
    }

    public static void main(String[] args) {
        NotifDAO no = new NotifDAO();
        System.out.println(no.loadNotifPerPageReceiver(0, 5, "HS001"));
    }
}
