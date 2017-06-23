package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Teacher;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            Teacher pa = new Teacher();
            ps = connect
                    .prepareStatement("SELECT * from GIAOVIEN where MA_GV=?");
            ps.setInt(1, idTe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pa.setIdTeacher(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setSex(rs.getString(3));
                pa.setAddress(rs.getString(4));
                pa.setDateBorn(rs.getDate(5));
                pa.setIdSchool(rs.getInt(6));
                pa.setUsername(rs.getString(7));
            }
            rs.close();
            return pa;
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
        TeacherDAO td = new TeacherDAO();
        System.out.println(td.showInformationTeacher(1).getName());
    }
}
