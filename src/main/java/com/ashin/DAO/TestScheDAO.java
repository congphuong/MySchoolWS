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
public class TestScheDAO {
    //method xem danh sach lich thi dua vao ma hoc ky
    public ArrayList<TestSchedule> showTestSchedule(int idSemester, int idClass) {
        Connection connect = null;
        PreparedStatement ps =null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<TestSchedule> listTestSCh = new ArrayList<TestSchedule>();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement("Select * from V_LICHTHI where HOC_KY=? AND V_LICHTHI.MA_LOP=?");

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
            rs.close();
            return listTestSCh;
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

    public ArrayList<TestSchedule> showTeacherTestSchedule(int idSemester, int idTeacher) {
        Connection connect = null;
        PreparedStatement ps =null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<TestSchedule> listTestSCh = new ArrayList<TestSchedule>();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement("Select * from V_LICHTHI where HOC_KY=? AND V_LICHTHI.MA_LOP=?");

            ps.setInt(1, idSemester);
            ps.setInt(2, idTeacher);
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
            rs.close();
            return listTestSCh;
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

    public ArrayList<TestSchedule> showTeacherOnTestSche(int semester, int idTeacher){
        Connection connect = null;
        PreparedStatement ps =null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<TestSchedule> listTestSCh = new ArrayList<TestSchedule>();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement("SELECT * FROM V_LICHTHI WHERE V_LICHTHI.HOC_KY=? AND V_LICHTHI.MA_GV_CT = ?");

            ps.setInt(1, semester);
            ps.setInt(2, idTeacher);
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
                ts.setIdTeacherWatch(rs.getInt(9));
                ts.setNameTeacher(rs.getString(10));
                listTestSCh.add(ts);
            }
            rs.close();
            return listTestSCh;
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
//        TestScheDAO testSchDAO = new TestScheDAO();
//        ArrayList<TestSchedule> list = new ArrayList<TestSchedule>();
//        list = testSchDAO.showTestSchedule(1);
//        for (TestSchedule ts : list) {
//            System.out.println(ts.getSemester() + " " + testSchDAO.getNameSubject(ts.getIdSubject()) + " " + ts.getTestDay() + " " +
//                    ts.getStartLesson() + " " + ts.getTestTime());
//        }
    }


}



