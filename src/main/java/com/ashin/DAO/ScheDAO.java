package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class ScheDAO {
    public ArrayList<Schedule> showSchedule(int idClass, int semester, int weekday) {
        try {
            ArrayList<Schedule> list = new ArrayList<Schedule>();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from thoikhoabieu where MA_LOP=? and HOC_KY=? and THU=?");
            ps.setInt(1, idClass);
            ps.setInt(2, semester);
            ps.setInt(3, weekday);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule sc = new Schedule();
                sc.setIdClass(rs.getInt(1));
                sc.setSemester(rs.getInt(2));
                sc.setIdSubject(rs.getInt(3));
                sc.setWeekday(rs.getInt(4));
                sc.setLesson(rs.getInt(5));
                list.add(sc);
            }
            return list;
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
//        ScheDAO scheduleDAO = new ScheDAO();
//        ArrayList<Schedule> list = new ArrayList<Schedule>();
//        list=scheduleDAO.showSchedule(1,1);
//        for (Schedule s:list) {
//            System.out.println(scheduleDAO.getNameSubject(s.getIdSubject())+" "+s.getWeekday()+" "+s.getLesson());
//        }
    }


}
