package com.ashin.DAO;

import com.ashin.model.Connect;
import com.ashin.model.ScoreBoard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by anluo on 4/16/2017.
 */
public class ScoreDAO {
    public ArrayList<ScoreBoard> showScore(int idStudent) {
        ArrayList<ScoreBoard> scoreBoards = new ArrayList<>();

        try {
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * FROM V_BANGDIEM WHERE V_BANGDIEM.MA_HS= ?");
            ps.setInt(1, idStudent);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nameStudent = rs.getString(1);
                int idStd = rs.getInt(2);
                String nameClass = rs.getNString(3);
                String nameSubject = rs.getString(4);
                double mieng = rs.getDouble(5);
                double mlphut = rs.getDouble(6);
                double mtiet = rs.getDouble(7);
                double cuoiKy = rs.getDouble(8);
                int hocKy = rs.getInt(10);

                ScoreBoard sc = new ScoreBoard(idStd, nameStudent, nameClass, nameSubject, mieng, mlphut, mtiet, cuoiKy, hocKy);
                sc.setTongket(sc.diemTongKet());

                scoreBoards.add(new ScoreBoard(idStd, nameStudent, nameClass, nameSubject, mieng, mlphut, mtiet, cuoiKy, hocKy));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scoreBoards;
    }

    public static void main(String[] args) {
        ScoreDAO sd = new ScoreDAO();
//        System.out.println(sd.showScore(1,1).getTotalScore());
        System.out.println(sd.showScore(14130241));
    }
}
