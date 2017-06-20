package com.ashin.model;

import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Teacher {
    int idTeacher, idSchool;
    String name, sex, address, username;
    Date dateBorn;

    public Teacher(int idTeacher, String name, String sex, String address, Date dateBorn, int idSchool, String username) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.username = username;
        this.dateBorn = dateBorn;
        this.idSchool = idSchool;
    }

    public Teacher() {
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

}
