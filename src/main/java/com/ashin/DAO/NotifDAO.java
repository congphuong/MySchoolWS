package com.ashin.DAO;

/**
 * Created by anluo on 6/3/2017.
 */

import com.ashin.controller.PushNotification;
import com.ashin.model.Connect;
import com.ashin.model.GroupNotification;
import com.ashin.model.Notification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NotifDAO {
    int numberPerPage = 10;
    private Connect connect = new Connect();
    PushNotification pn = new PushNotification();

    public void insert(Notification notif) {
        try {
            PreparedStatement ps = connect
                    .getPreparedStatement("insert into THONGBAO(ID_TB,NGUOIGUI,NGUOINHAN,TIEU_DE,NOI_DUNG,THOI_GIAN) values(?,?,?,?,?,?)");
            ps.setInt(1, notif.getId());
            ps.setString(2, notif.getSender());
            ps.setString(3, notif.getReceiver());
            ps.setString(4, notif.getTitle());
            ps.setString(5, notif.getNoti());
            ps.setTimestamp(6, notif.getDate());
            ps.executeUpdate();
            pn.sendNotification(notif);
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertGroup(GroupNotification grnotif) {
        try {
            Notification no = new Notification();
            int temp = grnotif.getId();
            for (int i = 0; i <grnotif.getReceiver().size() ; i++) {
                no = new Notification(grnotif.getSender(),grnotif.getReceiver().get(i),grnotif.getTitle(),grnotif.getNoti(),grnotif.getDate());
                PreparedStatement ps = connect
                        .getPreparedStatement("insert into THONGBAO(ID_TB,NGUOIGUI,NGUOINHAN,TIEU_DE,NOI_DUNG,THOI_GIAN) values(?,?,?,?,?,?)");
                ps.setInt(1, no.getId());
                ps.setString(2, no.getSender());
                ps.setString(3, no.getReceiver());
                ps.setString(4, no.getTitle());
                ps.setString(5, no.getNoti());
                ps.setTimestamp(6, no.getDate());
                ps.executeUpdate();
                pn.sendNotification(no);
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Notification view(int idno) {
        try {
            Notification no = new Notification();
            PreparedStatement ps = connect
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
            connect.close();
            return no;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int sizeByReceiver(String receiver) {
        int result =0;
        try {
            Notification no = new Notification();
            PreparedStatement ps = connect
                    .getPreparedStatement("select count(*) from THONGBAO where NGUOINHAN=?");
            ps.setString(1,receiver);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int sizeBySender(String sender) {
        int result =0;
        try {
            Notification no = new Notification();
            PreparedStatement ps = connect
                    .getPreparedStatement("select count(*) from THONGBAO where NGUOIGUI=?");
            ps.setString(1,sender);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public void update(int idNotif, Notification input) {
        try {
            PreparedStatement ps = connect
                    .getPreparedStatement("update THONGBAO set NOI_DUNG=? where ID_TB='" + idNotif + "'");
            ps.setString(1, input.getNoti());
            ps.executeUpdate();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Notification> loadNotifPerPageReceiver(int maxid,int numPerPage, String receiver) {
        List<Notification> ln = new ArrayList<>();
        try {
            String sql ="";
            if(maxid==0){
                sql = "SELECT * FROM THONGBAO WHERE NGUOINHAN='" + receiver + "'" + " order by ID_TB DESC LIMIT 0," + numPerPage ;
            }else {
                sql = "SELECT * FROM THONGBAO WHERE NGUOINHAN='" + receiver + "'" + " and ID_TB < " + maxid + " order by ID_TB DESC LIMIT 0," + numPerPage;
            }
            PreparedStatement ps = connect
                    .getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            rs.close();
            ps.close();
            connect.close();
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ln;
    }
    public List<Notification> loadNotifPerPageSender(int page,int numPerPage,String sender) {
        try {
            List<Notification> ln = new ArrayList<>();
            NotifDAO nd = new NotifDAO();
            Notification no = new Notification();
            int temp = nd.sizeBySender(sender);
            String sql = "";
            if (page*numPerPage>temp){return null;}
            if (page == pageNum(numPerPage,temp)) {
                sql = "SELECT * FROM THONGBAO"+ " WHERE NGUOIGUI='" + sender +"'" +"LIMIT 0," + temp % numPerPage ;
                System.out.println(sql + "tren");
            } else {
                sql = "SELECT * FROM THONGBAO "+" WHERE NGUOIGUI='" + sender +"'"+" LIMIT " + (temp - page * numPerPage) + "," + numPerPage ;
                System.out.println(sql);
            }
            PreparedStatement ps = connect
                    .getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ln.add(new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6)));
            }
            ps.close();
            connect.close();
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int pageNum(int numberPerPage,int input) {
        int result = 0;
        result = input / numberPerPage;
        if (input % numberPerPage != 0) {
            result++;
        }
        System.out.println("Page num"+result);
        return result;
    }

    public void updateToken(String idUser, String input) {
        try {
            Notification no = new Notification();
            PreparedStatement ps = connect
                    .getPreparedStatement("update TAIKHOAN set TOKEN=? where USERNAME='" + idUser + "'");
            ps.setString(1, input);
            ps.executeUpdate();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotifDAO no = new NotifDAO();
        System.out.println(no.loadNotifPerPageReceiver(0,5,"HS001"));
    }
}
