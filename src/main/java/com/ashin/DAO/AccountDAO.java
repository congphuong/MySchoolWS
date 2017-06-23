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
    private Connect connect = new Connect();
    public boolean checkAccount(String username, String password) {
        boolean login = false;
        try {
            Connection connection= connect.open();
            PreparedStatement ps = connection.prepareStatement("Select * from taikhoan where username=? and passwd=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login = true;
            }
            ps.close();
            connection.close();
        } catch (Exception e) {
        }
        return login;
    }

    public boolean checkUserExist(String username) {
        boolean check = false;
        try {
            PreparedStatement ps = connect.getPreparedStatement("Select username from taikhoan where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }
            connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    //method register
    public void register(Account account) {
        MessageResult registerMessage = new MessageResult();
        String sql = "insert into taikhoan(username,passwd,chucvu,machucvu,token) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connect.getPreparedStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getRole());
            ps.setString(4, account.getIdrole());
            ps.setString(5, account.getToken());
            if (ps.executeUpdate() > 0) {
                registerMessage.setSuccess(true);
                registerMessage.setMessage("Register Sucess.Wellcome!");
            }
            ps.close();
            connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // method change password
    public void changePasswd(String username, String oldPass, String newPass) {
        try {
            PreparedStatement ps = connect
                    .getPreparedStatement("update TAIKHOAN set passwd=? where USERNAME='" + username + "'");
            ps.setString(1, newPass);
            ps.executeUpdate();
            System.out.println("Succeed !");
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateToken(Account input) {
        try {
            PreparedStatement ps = connect
                    .getPreparedStatement("update TAIKHOAN set TOKEN=? where USERNAME='" + input.getUsername() + "'");
            ps.setString(1, input.getToken());
            ps.executeUpdate();
//            System.out.println("Succeed update token !");
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //
        AccountDAO accountDAO = new AccountDAO();
        System.out.println(accountDAO.getUserByUsername("admin"));
    }


    public User getUserByUsername(String username) {
        User user = null;
        Connection connection = null;
        ObjectPool pool= MyPool.getInstance();
        System.out.println( pool.getNumActive());
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
        }finally {
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null)
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
