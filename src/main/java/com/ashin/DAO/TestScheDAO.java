package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class TestScheDAO {
    //method xem danh sach lich thi dua vao ma hoc ky
    public ArrayList<TestSchedule> showTestSchedule(int idSemester) {
        ArrayList<TestSchedule> listTestSCh = new ArrayList<TestSchedule>();
        try {

            PreparedStatement ps = Connect.getPreparedStatement("Select * from LICHTHI where HOC_KY=?");

            ps.setInt(1, idSemester);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestSchedule ts = new TestSchedule();
                ts.setSemester(rs.getInt(1));
                ts.setIdSubject(rs.getInt(2));
                ts.setTestDay(rs.getDate(3));
                ts.setStartLesson(rs.getInt(4));
                ts.setTestTime(rs.getInt(5));

                listTestSCh.add(ts);
            }
            return listTestSCh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //method lay ten mon hoc
    public String getNameSubject(int idSubject) {
        try {
            String nameSubject = "";
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from monhoc where MA_MH=?");
            ps.setInt(1, idSubject);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nameSubject = rs.getString(2);
            }
            return nameSubject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //test
    public static void main(String[] args) {
        TestScheDAO testSchDAO = new TestScheDAO();
        ArrayList<TestSchedule> list = new ArrayList<TestSchedule>();
        list = testSchDAO.showTestSchedule(1);
        for (TestSchedule ts : list) {
            System.out.println(ts.getSemester() + " " + testSchDAO.getNameSubject(ts.getIdSubject()) + " " + ts.getTestDay() + " " +
                    ts.getStartLesson() + " " + ts.getTestTime());
        }
    }


}



