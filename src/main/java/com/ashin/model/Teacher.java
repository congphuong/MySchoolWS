package com.ashin.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Teacher {
    private int idTeacher;
    private String name, sex, address, username, nameClass, nameSchool;
    private Date dateBorn;
    private ArrayList<Student> students;

    public Teacher(int idTeacher, String name, String sex, String address, Date dateBorn, String nameSchool, String username, String nameClass) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.username = username;
        this.dateBorn = dateBorn;
        this.nameSchool = nameSchool;
        this.nameClass = nameClass;
    }

    public Teacher() {
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

}
