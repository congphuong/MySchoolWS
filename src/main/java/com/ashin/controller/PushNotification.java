package com.ashin.controller;

import com.ashin.DAO.NotifDAO;
import com.ashin.connection.MyPool;
import com.ashin.model.Notification;
import org.apache.commons.pool.ObjectPool;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by anluo on 4/26/2017.
 */
public class PushNotification {
    public final static String AUTH_KEY_FCM = "AAAAZSCKk3g:APA91bGzA-uPok0Q_lCcQSUMDa2WiBrvPSIlhWIqgh9TrunNQejCI9dQ0q07Jgww-4pMWHBLqDq5jkWfrbWWJGfFE5yqqseBp__S9Ckn3tsJfeAmCIQdnLEQTYcpgbrQUmD-XXwzvpz4";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public PushNotification() {
    }
    public String getToken(String username) {
        String token = null;
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("select token from TAIKHOAN where USERNAME='" + username + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                token = rs.getString(1);
            }

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
        return token;
    }
    public void sendNotification(Notification input)
            throws IOException {

        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;
        String token = getToken(input.getReceiver());
        if(token!=null) {
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + authKey);
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("to", token.trim());
            JSONObject info = new JSONObject();
            info.put("body", input.getNoti()); // Notification body
            info.put("title", input.getTitle());
            info.put("color", "#00ACD4");
            info.put("priority", "high");
            info.put("icon","ic_notif");
            info.put("group", "GROUP");
            info.put("id", input.getId());
            info.put("show_in_foreground", true);
            JSONObject data = new JSONObject();
            data.put("type","MEASURE_CHANGE");
            data.put("custom_notification",info);
            json.put("data", data);
            try {
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(json.toString());
                wr.flush();
                System.out.println(conn.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NotifDAO nd = new NotifDAO();
        PushNotification t1 = new PushNotification();
        Notification no = new Notification("admin2","HS001","abc","abc");
        System.out.println(t1.getToken(no.getReceiver()));
        try {
            t1.sendNotification(no);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
