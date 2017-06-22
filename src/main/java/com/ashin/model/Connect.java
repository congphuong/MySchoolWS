package com.ashin.model;

/**
 * Created by anluo on 6/3/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection open() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/project?useSSL=false", "root",
                    ""); // project thay ten database cua tui bay vao, username,pass điền vào
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            Connection con = open();
            if (con == null || con.isClosed()) {
                return null;
            }
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

