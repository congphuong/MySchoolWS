package com.ashin.model;

import java.util.Date;

/**
 * Created by Khuong on 2017-06-05.
 */
public class TestSchedule {
    private int semester;
    private int idSubject;
    private Date testDay;
    private int startLesson;
    private int testTime;

    public TestSchedule() {

    }

    public TestSchedule(int semester, int idSubject, Date testDay, int startLesson, int testTime) {
        this.semester = semester;
        this.idSubject = idSubject;
        this.testDay = testDay;
        this.startLesson = startLesson;
        this.testTime = testTime;
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
