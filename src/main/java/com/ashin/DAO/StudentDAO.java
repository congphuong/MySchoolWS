package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class StudentDAO {
    //method xem thong tin mot hoc sinh dua vao ma hoc sinh
    public Student showInformationStudent(int idStudent) {
        try {
            Student st = new Student();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from HOCSINH where MA_HS=?");
            ps.setInt(1, idStudent);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                st.setIdStudent(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setDateBorn(rs.getDate(3));
                st.setSex(rs.getString(4));
                st.setIdClass(rs.getInt(5));
                st.setIdSchool(rs.getInt(6));
                st.setAddress(rs.getString(7));
                st.setPhone(rs.getInt(8));
                st.setUsername(rs.getString(9));
            }
            return st;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //method lay ten lop
    public String getNameClass(int idClass) {
        try {
            String nameSubject = "";
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from lop where MA_LOP=?");
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nameSubject = rs.getString(3);
            }
            return nameSubject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // method xem danh sach hoc sinh trong mot lop dua vao ma lop
    public ArrayList<Student> showListStudent(int idClass) {
        try {
            ArrayList<Student> listStudent = new ArrayList<Student>();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from hocsinh where MA_LOP=?");
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
                listStudent.add(st);
            }
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //test
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> list = new ArrayList<Student>();
        list = studentDAO.showListStudent(1);
        for (Student s : list) {
            System.out.println(s.getIdStudent() + " " + s.getName() + " " + s.getDateBorn() + " " + " "
                    + s.getSex() + " " + studentDAO.getNameClass(s.getIdClass()) + " " + s.getAddress());
        }

    }


}
