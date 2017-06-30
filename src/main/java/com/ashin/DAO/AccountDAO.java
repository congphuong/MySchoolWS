package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.*;
import org.apache.commons.pool.ObjectPool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Khuong on 2017-06-05.
 */
public class AccountDAO {
    public boolean checkAccount(String username, String password) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        boolean login = false;
        try {
            ps = connect.prepareStatement("Select * from taikhoan where username=? and passwd=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login = true;
            }
            ps.close();
            connect.close();
        } catch (Exception e) {
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
        return login;
    }

    public boolean checkUserExist(String username) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        boolean check = false;
        try {
            ps = connect.prepareStatement("Select username from taikhoan where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
        return check;
    }


    // method change password
    public void changePasswd(String username, String oldPass, String newPass) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("update TAIKHOAN set passwd=? where USERNAME='" + username + "'");
            ps.setString(1, newPass);
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

    public void updateToken(Account input) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("update TAIKHOAN set TOKEN=? where USERNAME='" + input.getUsername() + "'");
            ps.setString(1, input.getToken());
            ps.executeUpdate();
//            System.out.println("Succeed update token !");
            connect.close();
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
    }



    public static void main(String[] args) {
        //
        AccountDAO accountDAO = new AccountDAO();
        System.out.println(accountDAO.getUserByUsername("ADMIN"));
        System.out.println(accountDAO.getUserByUsername("ADMIN"));

    }


    public User getUserByUsername(String username) {
        User user = null;
        Connection connection = null;
        ObjectPool pool = MyPool.getInstance();
        System.out.println(pool.getNumActive());
        System.out.println(pool.getNumIdle());

        try {
            connection = (Connection) pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("Select * from taikhoan where username=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setChucVu(rs.getString(4));
                user.setMaChucVu(rs.getInt(5));
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
                if (connection != null)
                    pool.returnObject(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
