package com.ashin.model;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Schedule {
    private int idTeacher;
    private int idClass;
    private String nameClass;
    private int idSubject;
    private String nameSubject;
    private int semester;
    private int weekday;
    private int lesson;

    public Schedule() {
    }

    public Schedule(int idTeacher, int idClass, String nameClass, int idSubject, String nameSubject, int semester, int weekday, int lesson) {
        this.idTeacher = idTeacher;
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.semester = semester;
        this.weekday = weekday;
        this.lesson = lesson;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
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
