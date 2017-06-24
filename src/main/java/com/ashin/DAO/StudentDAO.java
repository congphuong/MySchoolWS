package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.*;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class StudentDAO {
    //method xem thong tin mot hoc sinh dua vao ma hoc sinh
    public static Student showInformationStudent(int idStudent) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            Student st = new Student();
            ps = connect
                    .prepareStatement("SELECT * FROM V_INFOSTD WHERE V_INFOSTD.MA_HS = ?");
            ps.setInt(1, idStudent);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                st.setIdStudent(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setDateBorn(rs.getDate(3));
                st.setSex(rs.getString(4));
                st.setIdClass(rs.getInt(5));
                st.setNameClass(rs.getString(6));
                st.setIdSchool(rs.getInt(7));
                st.setNameSchool(rs.getString(8));
                st.setAddress(rs.getString(9));
                st.setPhone(rs.getInt(10));
                st.setUsername(rs.getString(11));
            }
            rs.close();
            return st;
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
    // method xem danh sach hoc sinh trong mot lop dua vao ma lop
    public ArrayList<Student> showListStudent(int idClass) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ArrayList<Student> listStudent = new ArrayList<Student>();
            ps = connect
                    .prepareStatement("SELECT * FROM V_INFOSTD where V_INFOSTD.MA_LOP=? AND V_INFOSTD.USERNAME IS NOT NULL;");
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student st = new Student();
                st.setIdStudent(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setDateBorn(rs.getDate(3));
                st.setSex(rs.getString(4));
                st.setIdClass(rs.getInt(5));
                st.setNameClass(rs.getString(6));
                st.setIdSchool(rs.getInt(7));
                st.setNameSchool(rs.getString(8));
                st.setAddress(rs.getString(9));
                st.setPhone(rs.getInt(10));
                st.setUsername(rs.getString(11));

                listStudent.add(st);
            }
            rs.close();
            return listStudent;
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

    //test
    public static void main(String[] args) {


    }


}
