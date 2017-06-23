package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.ScoreBoard;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by anluo on 4/16/2017.
 */
public class ScoreDAO {
    public ArrayList<ScoreBoard> showScore(int idStudent) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<ScoreBoard> scoreBoards = new ArrayList<>();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("SELECT * FROM V_BANGDIEM WHERE V_BANGDIEM.MA_HS= ?");
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
                double tongKet = rs.getDouble(9);
                int hocKy = rs.getInt(10);

                scoreBoards.add( new ScoreBoard(idStd, nameStudent, nameClass, nameSubject, mieng, mlphut, mtiet, cuoiKy, tongKet, hocKy));
            }
            rs.close();
            return scoreBoards;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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

        return scoreBoards;
    }

    public static void main(String[] args) {
        ScoreDAO sd = new ScoreDAO();
//        System.out.println(sd.showScore(1,1).getTotalScore());
        System.out.println(sd.showScore(5));
    }
}
