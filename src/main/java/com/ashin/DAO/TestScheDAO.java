package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class TestScheDAO {
    private Connect connect = new Connect();
    //method xem danh sach lich thi dua vao ma hoc ky
    public ArrayList<TestSchedule> showTestSchedule(int idSemester, int idClass) {
        ArrayList<TestSchedule> listTestSCh = new ArrayList<TestSchedule>();
        try {

            PreparedStatement ps = connect.getPreparedStatement("Select * from V_LICHTHI where HOC_KY=? AND V_LICHTHI.MA_LOP=?");

            ps.setInt(1, idSemester);
            ps.setInt(2, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestSchedule ts = new TestSchedule();
                ts.setSemester(rs.getInt(1));
                ts.setIdSubject(rs.getInt(2));
                ts.setNameSubject(rs.getString(3));
                ts.setIdClass(rs.getInt(4));
                ts.setNameClass(rs.getString(5));
                ts.setTestDay(rs.getTimestamp(6));
                ts.setStartLesson(rs.getInt(7));
                ts.setTestTime(rs.getInt(8));

                listTestSCh.add(ts);
            }
            connect.close();
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
            PreparedStatement ps = connect
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
        connect.close();
        return "";
    }

    //test
    public static void main(String[] args) {
//        TestScheDAO testSchDAO = new TestScheDAO();
//        ArrayList<TestSchedule> list = new ArrayList<TestSchedule>();
//        list = testSchDAO.showTestSchedule(1);
//        for (TestSchedule ts : list) {
//            System.out.println(ts.getSemester() + " " + testSchDAO.getNameSubject(ts.getIdSubject()) + " " + ts.getTestDay() + " " +
//                    ts.getStartLesson() + " " + ts.getTestTime());
//        }
    }


}



