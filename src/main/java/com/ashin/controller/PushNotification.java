package com.ashin.controller;

import com.ashin.DAO.NotifDAO;
import com.ashin.model.Notification;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by anluo on 4/26/2017.
 */
public class PushNotification {
    public final static String AUTH_KEY_FCM = "AAAAAhOy5-s:APA91bFT4GKjVoQ8qb-hVGUwnFCOw6oIeFFY8aYJkgzjn0UOZOMQTtdFZHgCFXqT9Osd87BwpQJMsNj1Ijbjg4DwmtswWinnM3IFHExyyVtkbN6BpZ9_I6MZgfrMZur_cBUQ4rVLZRgM";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
    public final static String APP_TOKEN = "dozCYft70DM:APA91bEq_O-esnGLq2hygrr00eiUY2J_-0UeBmpM88lENgipdTmiWWX9A13P-wIlTXvaP6luPSFDAytOrJjm6T8l2ed53luuy6_E_-SDDwYlPwZ7Gi0kFS25aHqyhas4BThSXYKx3ysc";

    public PushNotification() {
    }

    public static void sendNotification(Notification input)
            throws IOException {

        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("to", APP_TOKEN.trim());
        JSONObject info = new JSONObject();
        info.put("title", input.getTitle()); // Notification title
        info.put("body", input.getNoti()); // Notification body
        json.put("notification", info);
        try {
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            System.out.println(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotifDAO nd = new NotifDAO();
        PushNotification t1 = new PushNotification();
        try {
            t1.sendNotification(nd.view(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
