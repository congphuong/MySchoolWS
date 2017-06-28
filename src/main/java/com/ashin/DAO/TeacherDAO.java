package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Student;
import com.ashin.model.Teacher;
import com.ashin.model.Topic;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by anluo on 4/16/2017.
 */
public class TeacherDAO {
    public Teacher showInformationTeacher(int idTe) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            Teacher teacher = new Teacher();
            ps = connect
                    .prepareStatement("SELECT * FROM V_INFOTEACHER where V_INFOTEACHER.MA_GV=?");
            ps.setInt(1, idTe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                teacher.setIdTeacher(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setSex(rs.getString(3));
                teacher.setAddress(rs.getString(4));
                teacher.setDateBorn(rs.getDate(5));
                teacher.setNameSchool(rs.getString(6));
                teacher.setUsername(rs.getString(7));
                teacher.setNameClass(rs.getString(8));
                teacher.setIdClass(rs.getInt(9));

            }
            rs.close();
            return teacher;
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
        return null;
    }

    public static void main(String[] args) {

    }
}
