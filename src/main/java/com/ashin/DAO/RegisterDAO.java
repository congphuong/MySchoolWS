package com.ashin.DAO;

import com.ashin.model.Connect;
import com.ashin.model.User;
import com.ashin.model.UserRegister;
import com.ashin.model.VerifyCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by trile on 6/20/2017.
 */
public class RegisterDAO {
    public static ArrayList<User> getAllsUser() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        PreparedStatement ps = Connect.getPreparedStatement(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String chucVu = rs.getString(4);
                int maChucVu = rs.getInt(5);

                users.add(new User(userID, userName, password, chucVu, maChucVu));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.close();
        return users;
    }

    private static ArrayList<VerifyCode> getVerifyCode() {
        ArrayList<VerifyCode> verifyCodes = new ArrayList<>();
        String sql = "SELECT * FROM maxacnhan";
        PreparedStatement ps = Connect.getPreparedStatement(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int verifyCode = rs.getInt(1);
                int idRole = rs.getInt(2);
                String nameRole = rs.getString(3);

                verifyCodes.add(new VerifyCode(verifyCode, idRole, nameRole));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.close();
        return verifyCodes;
    }

    private static ArrayList<User> allUser = getAllsUser();

    private static ArrayList<VerifyCode> verifyCodes = getVerifyCode();

    public static boolean checkUser(UserRegister ur) {
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

    public static VerifyCode getVerify(UserRegister userRegister) {
        VerifyCode tmp = null;
        for (int i = 0; i < verifyCodes.size(); i++) {
            if (userRegister.getVerifyCode() == verifyCodes.get(i).getVerifyCode()) {
                tmp = verifyCodes.get(i);
                break;
            }
        }
        return tmp;
    }

    public static int addUser(UserRegister ur) {
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String sql = "CALL THEM_TAIKHOAN(?,?,?,?);";
        PreparedStatement ps = Connect.getPreparedStatement(sql);
        try {
            if (checkUser(ur)) {
                VerifyCode verifyCode = getVerify(ur);
                ps.setString(1, ur.getUserName());
                ps.setString(2, bpe.encode(ur.getPassword()));
                ps.setString(3, verifyCode.getNameRole());
                ps.setInt(4, verifyCode.getIdRole());
                ps.executeUpdate();
                return 1;
            }
            Connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        RegisterDAO rd = new RegisterDAO();
        ArrayList<User> users = RegisterDAO.getAllsUser();

        String password;
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        password = b.encode("anhtri");

        UserRegister ur = new UserRegister("HS004", "ASCASC", 113);
//        UserRegister ur1 = new UserRegister("ADMIN", "ADMIN", 111);
        UserRegister ur2 = new UserRegister("HS001", "HS001", 117);
        UserRegister ur3 = new UserRegister("HS002", "HS002", 115);
        UserRegister ur4 = new UserRegister("HS003", "HS003", 116);

        System.out.println(rd.checkUser(ur));

        System.out.println(rd.getVerify(ur));

        System.out.println(users.size());

        System.out.println(addUser(ur));
//        System.out.println(addUser(ur1));
        System.out.println(addUser(ur2));
        System.out.println(addUser(ur3));
        System.out.println(addUser(ur4));

    }
}
