package com.ashin.model;

import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class TestSchedule {
    private int semester;
    private int idSubject;
    private String nameSubject;
    private int idClass;
    private String nameClass;
    private Date testDay;
    private int startLesson;
    private int testTime;
    private int idTeacherWatch;
    private String nameTeacher;

    public TestSchedule() {
    }

    public TestSchedule(int semester, int idSubject, String nameSubject, int idClass, String nameClass, Date testDay, int startLesson, int testTime, int idTeacherWatch, String nameTeacher) {
        this.semester = semester;
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.testDay = testDay;
        this.startLesson = startLesson;
        this.testTime = testTime;
        this.idTeacherWatch = idTeacherWatch;
        this.nameTeacher = nameTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public int getIdTeacherWatch() {
        return idTeacherWatch;
    }

    public void setIdTeacherWatch(int idTeacherWatch) {
        this.idTeacherWatch = idTeacherWatch;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public Date getTestDay() {
        return testDay;
    }

    public void setTestDay(Date testDay) {
        this.testDay = testDay;
    }

    public int getStartLesson() {
        return startLesson;
    }

    public void setStartLesson(int startLesson) {
        this.startLesson = startLesson;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }

}
