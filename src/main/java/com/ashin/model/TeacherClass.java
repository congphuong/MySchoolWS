package com.ashin.model;

/**
 * Created by trile on 6/29/2017.
 */
public class TeacherClass {
    private int idClass;
    private String nameClass;

    public TeacherClass() {
    }

    public TeacherClass(int idClass, String nameClass) {
        this.idClass = idClass;
        this.nameClass = nameClass;
    }


    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
