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

    public int addUser(UserRegister ur) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String sql = "CALL THEM_TAIKHOAN(?,?,?);";
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement(sql);
            ps.setString(1, ur.getUserName());
            ps.setString(2, bpe.encode(ur.getPassword()));
            ps.setInt(3, ur.getVerifyCode());
            ps.executeUpdate();
            ps.close();
            return 1;
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
