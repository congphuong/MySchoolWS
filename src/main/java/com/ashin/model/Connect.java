package com.ashin.model;

/**
 * Created by anluo on 6/3/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection open() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/MYSCHOOL1?useSSL=false", "root",
                    "1234"); // project thay ten database cua tui bay vao, user,pass điền vào
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
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

    public static void close() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connect n1 = new Connect();
        open();
    }
}

