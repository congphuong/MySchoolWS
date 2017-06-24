package com.ashin.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Parent {
    private int idParent;
    private String name;
    private String sex;
    private Date dateBorn;
    private String address;
    private String username;
    private ArrayList<Student> students;

    public Parent(int idParent, String name, String sex, Date dateBorn, String address, String username) {
        this.idParent = idParent;
        this.name = name;
        this.dateBorn = dateBorn;
        this.address = address;
        this.username = username;
        this.sex = sex;
    }

    public Parent() {
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
