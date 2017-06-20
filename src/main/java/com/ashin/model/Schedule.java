package com.ashin.model;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Schedule {
    private int idClass;
    private int semester;
    private int idSubject;
    private int weekday;
    private int lesson;

    public Schedule() {
    }

    public Schedule(int idClass, int semester, int idSubject, int weekday, int lesson) {
        this.idClass = idClass;
        this.semester = semester;
        this.idSubject = idSubject;
        this.weekday = weekday;
        this.lesson = lesson;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
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

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }


}
