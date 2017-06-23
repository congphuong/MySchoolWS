package com.ashin.model;

/**
 * Created by anluo on 6/3/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    private Connection conn;


    public Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/project", "root",
                        "");
                return conn;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
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

