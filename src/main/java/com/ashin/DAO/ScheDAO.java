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
public class ScheDAO {
    public ArrayList<Schedule> showSchedule(int idClass, int semester, int weekday) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        try {
            connect = (Connection) pool.borrowObject();
            ArrayList<Schedule> list = new ArrayList<Schedule>();
            ps = connect.prepareStatement("SELECT * from V_TKB where V_TKB.MA_LOP=? and V_TKB.HOC_KY=? and V_TKB.THU=?");
            ps.setInt(1, idClass);
            ps.setInt(2, semester);
            ps.setInt(3, weekday);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule sc = new Schedule();
                sc.setIdTeacher(rs.getInt(1));
                sc.setIdClass(rs.getInt(2));
                sc.setNameClass(rs.getString(3));
                sc.setIdSubject(rs.getInt(4));
                sc.setNameSubject(rs.getString(5));
                sc.setSemester(rs.getInt(6));
                sc.setWeekday(rs.getInt(7));
                sc.setLesson(rs.getInt(8));
                list.add(sc);
            }
            rs.close();
            return list;
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
//        ScheDAO scheduleDAO = new ScheDAO();
//        ArrayList<Schedule> list = new ArrayList<Schedule>();
//        list=scheduleDAO.showSchedule(1,1);
//        for (Schedule s:list) {
//            System.out.println(scheduleDAO.getNameSubject(s.getIdSubject())+" "+s.getWeekday()+" "+s.getLesson());
//        }
    }


}
