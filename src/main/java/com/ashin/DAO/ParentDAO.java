package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Parent;
import com.ashin.model.Student;
import org.apache.commons.pool.ObjectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class ParentDAO {
    public ArrayList<Parent> showListParents(int idClass) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<Parent> list = new ArrayList<Parent>();
        try {
            connect = (Connection) pool.borrowObject();
            ps = connect.prepareStatement("SELECT * FROM V_PHTHEOLOP WHERE V_PHTHEOLOP.MA_LOP = ?");
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Parent pa = new Parent();
                pa.setIdParent(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setSex(rs.getString(3));
                pa.setDateBorn(rs.getDate(4));
                pa.setAddress(rs.getString(5));
                pa.setUsername(rs.getString(6));
                list.add(pa);
            }
            rs.close();
            ps.close();
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
        return list;
    }

    public Parent showInformationParent(int idPa) {
        Connection connect = null;
        PreparedStatement ps = null;
        ObjectPool pool = MyPool.getInstance();
        ArrayList<Student> students = new ArrayList<>();
        try {
            Parent pa = new Parent();
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("SELECT * from V_INFOPARENTS where V_INFOPARENTS.MA_PH=?");
            ps.setInt(1, idPa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pa.setIdParent(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setDateBorn(rs.getDate(3));
                pa.setAddress(rs.getString(4));
                pa.setUsername(rs.getString(5));
                pa.setSex(rs.getString(6));

                Student student = StudentDAO.showInformationStudent(rs.getInt(7));
                students.add(student);
            }
            rs.close();
            pa.setStudents(students);
            return pa;
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

    public static void main(String[] args) {

    }


}

