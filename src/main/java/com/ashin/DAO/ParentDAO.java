package com.ashin.DAO;

import com.ashin.connection.MyPool;
import com.ashin.model.Parent;
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
        try {
            Parent pa = new Parent();
            connect = (Connection) pool.borrowObject();
            ps = connect
                    .prepareStatement("SELECT * from PHUHUYNH where MA_PH=?");
            ps.setInt(1, idPa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pa.setIdParent(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setSex(rs.getString(6));
                pa.setDateBorn(rs.getDate(3));
                pa.setAddress(rs.getString(4));
                pa.setUsername(rs.getString(5));
            }
            rs.close();
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
        ParentDAO pd = new ParentDAO();
        ArrayList<Parent> list = new ArrayList<Parent>();
        list = pd.showListParents(1);
        for (Parent parent : list) {
            System.out.println(parent.getIdParent() + " " + parent.getName() + " "
                    + parent.getSex() + " " + parent.getDateBorn() + " " + parent.getAddress());
        }

    }


}

