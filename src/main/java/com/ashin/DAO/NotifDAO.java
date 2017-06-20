package com.ashin.DAO;

/**
 * Created by anluo on 6/3/2017.
 */

import com.ashin.controller.PushNotification;
import com.ashin.model.Connect;
import com.ashin.model.Notification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NotifDAO {
    int numberPerPage = 10;
    PushNotification pn = new PushNotification();

    public void insert(Notification notif) {
        try {
            PreparedStatement ps = Connect
                    .getPreparedStatement("insert into THONGBAO(ID_TB,NGUOIGUI,NGUOINHAN,TIEU_DE,NOI_DUNG,THOI_GIAN) values(?,?,?,?,?,?)");
            ps.setInt(1, notif.getId());
            ps.setString(2, notif.getSender());
            ps.setString(3, notif.getReceiver());
            ps.setString(4, notif.getTitle());
            ps.setString(5, notif.getNoti());
            ps.setTimestamp(6, notif.getDate());
            ps.executeUpdate();
            pn.sendNotification(notif);
            System.out.println("Succeed !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Notification view(int idno) {
        try {
            Notification no = new Notification();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from THONGBAO where ID_TB=?");
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
            return no;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Notification> viewByReceiver(String receiver) {
        try {
            List<Notification> ln = new ArrayList<>();
            Notification no = new Notification();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from THONGBAO where NGUOINHAN=?");
            ps.setString(1, receiver);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Notification> viewBySender(String sender) {
        try {
            List<Notification> ln = new ArrayList<>();
//            Notification no = new Notification();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from THONGBAO where NGUOIGUI=?");
            ps.setString(1, sender);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Notification> viewAll() {
        try {
            List<Notification> ln = new ArrayList<>();
            Notification no = new Notification();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from THONGBAO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(int idNotif, Notification input) {
        try {
            PreparedStatement ps = Connect
                    .getPreparedStatement("update THONGBAO set NOI_DUNG=? where ID_TB='" + idNotif + "'");
            ps.setString(1, input.getNoti());
            ps.executeUpdate();
            System.out.println("Succeed !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Notification> loadNotifPerPage(int page) {
        try {
            List<Notification> ln = new ArrayList<>();
            Notification no = new Notification();
            String sql = "";
            if (page == pageNum()) {
                sql = "SELECT * FROM THONGBAO LIMIT 0," + sizeList() % numberPerPage;
                System.out.println(sql + "tren");
            } else {
                sql = "SELECT * FROM THONGBAO LIMIT " + (sizeList() - page * numberPerPage) + "," + numberPerPage;
                System.out.println(sql);
            }
            PreparedStatement ps = Connect
                    .getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int sizeList() {
        NotifDAO nd = new NotifDAO();
        int size = nd.viewAll().size();
        return size;
    }

    public static int pageNum() {
        int result = 0;
        result = sizeList() / 5;
        if (sizeList() % 5 != 0) {
            result++;
        }
        return result;
    }

    public void updateToken(String idUser, String input) {
        try {
            Notification no = new Notification();
            PreparedStatement ps = Connect
                    .getPreparedStatement("update TAIKHOAN set TOKEN=? where USERNAME='" + idUser + "'");
            ps.setString(1, input);
            ps.executeUpdate();
            System.out.println("Succeed !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotifDAO no = new NotifDAO();
        System.out.println(no.viewBySender("Ashin").size());
        List<Notification> e1 = no.viewBySender("Ashin");
        for (int i = 0; i < e1.size(); i++) {
            System.out.println(e1.get(i).getId());
        }
//        System.out.println(no.sizeList());
//        System.out.println(no.loadNotifPerPage(1).toString());
//        Timestamp t1 = new Timestamp(System.currentTimeMillis());
//        Notification n1 = new Notification("Ashin","tretrau","asoidhaslddfdfgkhsad ","sdfsdfgdfgdfsdaf",t1);
//        Notification n2 = new Notification("Ashin","tretrau","asoidhaslddfdfgkhsad ","moi doi ne",t1);
//        no.insert(n1);
//        System.out.println(no.viewAll().size());
//        no.update(3,n2);
//        no.updateToken("Ashin","130396");
    }
}
