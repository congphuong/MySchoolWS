package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class StudentDAO {
    private Connect connect = new Connect();
    //method xem thong tin mot hoc sinh dua vao ma hoc sinh
    public Student showInformationStudent(int idStudent) {
        try {
            Student st = new Student();
            PreparedStatement ps = connect
                    .getPreparedStatement("SELECT * from HOCSINH where MA_HS=?");
            ps.setInt(1, idStudent);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                st.setIdStudent(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setDateBorn(rs.getDate(4));
                st.setSex(rs.getString(5));
                st.setIdSchool(rs.getInt(6));
                st.setAddress(rs.getString(7));
                st.setPhone(rs.getInt(8));
                st.setUsername(rs.getString(3));
            }
            connect.close();
            return st;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //method lay ten lop


    // method xem danh sach hoc sinh trong mot lop dua vao ma lop
    public ArrayList<Student> showListStudent(int idClass) {
        try {
            ArrayList<Student> listStudent = new ArrayList<Student>();
            PreparedStatement ps = connect
                    .getPreparedStatement("SELECT * FROM V_INFOSTD where V_INFOSTD.MA_LOP=? AND V_INFOSTD.USERNAME IS NOT NULL;");
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student st = new Student();
                st.setIdStudent(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setDateBorn(rs.getDate(3));
                st.setSex(rs.getString(4));
                st.setIdClass(rs.getInt(5));
                st.setIdSchool(rs.getInt(6));
                st.setAddress(rs.getString(7));
                st.setPhone(rs.getInt(8));
                st.setUsername(rs.getString(9));

                listStudent.add(st);
            }
            connect.close();
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //test
    public static void main(String[] args) {


    }


}
