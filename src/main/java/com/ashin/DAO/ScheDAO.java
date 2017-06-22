package com.ashin.DAO;

import com.ashin.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class ScheDAO {
    private Connect connect = new Connect();
    public ArrayList<Schedule> showSchedule(int idClass, int semester, int weekday) {
        try {
            ArrayList<Schedule> list = new ArrayList<Schedule>();
            PreparedStatement ps = connect
                    .getPreparedStatement("SELECT * from V_TKB where V_TKB.MA_LOP=? and V_TKB.HOC_KY=? and V_TKB.THU=?");
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
            connect.close();
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
            PreparedStatement ps = connect
                    .getPreparedStatement("SELECT * from monhoc where MA_MH=?");
            ps.setInt(1, idSubject);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nameSubject = rs.getString(2);
            }
            connect.close();
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
