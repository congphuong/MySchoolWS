package com.ashin.DAO;

import com.ashin.model.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Khuong on 2017-06-05.
 */
public class AccountDAO {
    public boolean checkAccount(String username, String password) {
        boolean login = false;
        try {
            PreparedStatement ps = Connect.getPreparedStatement("Select * from taikhoan where username=? and passwd=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login = true;
            }
            Connect.close();
        } catch (Exception e) {
        }
        return login;
    }

    public boolean checkUserExist(String username) {
        boolean check = false;
        try {
            PreparedStatement ps = Connect.getPreparedStatement("Select username from taikhoan where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }
            Connect.close();
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
            PreparedStatement ps = Connect.getPreparedStatement(sql);
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
            Connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // method change password
    public void changePasswd(String username, String oldPass, String newPass) {
        try {
            PreparedStatement ps = Connect
                    .getPreparedStatement("update TAIKHOAN set passwd=? where USERNAME='" + username + "'");
            ps.setString(1, newPass);
            ps.executeUpdate();
            System.out.println("Succeed !");
            Connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateToken(Account input) {
        try {
            PreparedStatement ps = Connect
                    .getPreparedStatement("update TAIKHOAN set TOKEN=? where USERNAME='" + input.getUsername() + "'");
            ps.setString(1, input.getToken());
            ps.executeUpdate();
//            System.out.println("Succeed update token !");
            Connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //
        AccountDAO accountDAO = new AccountDAO();
        MessageResult registerResult = new MessageResult();
//        accountDAO.register(new Account("anh3","1234","ph","135","akda"));
        System.out.println();

//
//         boolean success = accountDAO.checkAccount("khuong","4321");
//          System.out.println(success);
//
//
        System.out.println(accountDAO.checkAccount("anh3", "1234"));
        accountDAO.changePasswd("ly", "1234", "4321");
//        System.out.println(accountDAO.checkAccount("khuong","4321"));
    }


    public User getUserByUsername(String username) {
        User user = null;
        try {
            PreparedStatement ps = Connect.getPreparedStatement("Select * from taikhoan where username=?");
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
            Connect.close();
        } catch (Exception e) {
        }
        return user;
    }
}
