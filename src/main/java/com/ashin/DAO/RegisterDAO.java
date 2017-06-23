package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.User;
import com.ashin.model.UserRegister;
import com.ashin.model.VerifyCode;
import org.apache.commons.pool.ObjectPool;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by trile on 6/20/2017.
 */
public class RegisterDAO {
    public ArrayList<User> getAllsUser() {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();

        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String chucVu = rs.getString(4);
                int maChucVu = rs.getInt(5);

                users.add(new User(userID, userName, password, chucVu, maChucVu));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        return users;
    }

    private ArrayList<VerifyCode> getVerifyCode() {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<VerifyCode> verifyCodes = new ArrayList<>();
        String sql = "SELECT * FROM maxacnhan";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int verifyCode = rs.getInt(1);
                int idRole = rs.getInt(2);
                String nameRole = rs.getString(3);

                verifyCodes.add(new VerifyCode(verifyCode, idRole, nameRole));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        return verifyCodes;
    }

    private ArrayList<User> allUser = getAllsUser();

    private ArrayList<VerifyCode> verifyCodes = getVerifyCode();

    public boolean checkUser(UserRegister ur) {
        boolean tmp = false;
        for (int i = 0; i < allUser.size(); i++) {
            if (!ur.getUserName().equals(allUser.get(i).getUsername())) {
                tmp = true;
                break;
            }
        }
        for (int i = 0; i < verifyCodes.size(); i++) {
            if (ur.getVerifyCode() == verifyCodes.get(i).getVerifyCode()) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }

    public VerifyCode getVerify(UserRegister userRegister) {
        VerifyCode tmp = null;
        for (int i = 0; i < verifyCodes.size(); i++) {
            if (userRegister.getVerifyCode() == verifyCodes.get(i).getVerifyCode()) {
                tmp = verifyCodes.get(i);
                break;
            }
        }
        return tmp;
    }

    public int addUser(UserRegister ur) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String sql = "CALL THEM_TAIKHOAN(?,?,?,?);";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            if (checkUser(ur)) {
                VerifyCode verifyCode = getVerify(ur);
                ps.setString(1, ur.getUserName());
                ps.setString(2, bpe.encode(ur.getPassword()));
                ps.setString(3, verifyCode.getNameRole());
                ps.setInt(4, verifyCode.getIdRole());
                ps.executeUpdate();
                return 1;
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        return 0;
    }

}
