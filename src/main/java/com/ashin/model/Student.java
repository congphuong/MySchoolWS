package com.ashin.model;

import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Student {
    private int idStudent, idClass, idSchool, phone;
    private String name, sex, address, username, nameClass, nameSchool;
    private Date dateBorn;

    public Student(int idStudent, int idClass, int idSchool, int phone, String name, String sex, String address, String username, String nameClass, String nameSchool, Date dateBorn) {
        this.idStudent = idStudent;
        this.idClass = idClass;
        this.idSchool = idSchool;
        this.phone = phone;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.username = username;
        this.nameClass = nameClass;
        this.nameSchool = nameSchool;
        this.dateBorn = dateBorn;
    }

    public Student() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

}
