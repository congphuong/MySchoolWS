package com.ashin.DAO;

import com.ashin.model.Connect;
import com.ashin.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by anluo on 4/16/2017.
 */
public class TeacherDAO {
    public Teacher showInformationTeacher(int idTe) {
        try {
            Teacher pa = new Teacher();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from GIAOVIEN where MA_GV=?");
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
            return pa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TeacherDAO td = new TeacherDAO();
        System.out.println(td.showInformationTeacher(1).getName());
    }
}
