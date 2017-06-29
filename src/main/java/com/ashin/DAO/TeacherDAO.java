package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.TeacherClass;
import com.ashin.model.Teacher;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<TeacherClass> getListClasses(int idTeacher) {
        ArrayList<TeacherClass> teacherClasses = new ArrayList<>();
        String sql = "SELECT * FROM V_TEACHERCLASS WHERE V_TEACHERCLASS.NAM_HOC=? AND V_TEACHERCLASS.MA_GV=?";
        Connection connection = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();

        Date date = new Date();

        int year = 1900 + date.getYear();
        int month = date.getMonth();

        if (month > 7) {
            year++;
        }

        try {
            connection = (Connection) pool.borrowObject();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, year);
            ps.setInt(2, idTeacher);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idClass = rs.getInt(3);
                String nameClass = rs.getString(4);
                teacherClasses.add(new TeacherClass(idClass, nameClass));
            }
            rs.close();
            return teacherClasses;
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
        return null;
    }

    public static void main(String[] args) {

    }
}
