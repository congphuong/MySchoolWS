package com.ashin.model;

/**
 * Created by anluo on 4/16/2017.
 */
public class ScoreBoard {

    private int idStudent;
    private int idClass;
    private String nameStudent;
    private String nameClass;
    private String nameSubject;
    private double mieng, mlphut, mtiet, cuoiky, tongket;
    private int term;

    public ScoreBoard(int idStudent, int idClass, String nameStudent, String nameClass, String nameSubject, double mieng, double mlphut, double mtiet, double cuoiky, int term) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSubject = nameSubject;
        this.mieng = mieng;
        this.mlphut = mlphut;
        this.mtiet = mtiet;
        this.cuoiky = cuoiky;
        this.term = term;
        this.idClass = idClass;
    }

    public ScoreBoard(int idStudent, String nameStudent, String nameClass, String nameSubject, double mieng, double mlphut, double mtiet, double cuoiky, double tongket, int term) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSubject = nameSubject;
        this.mieng = mieng;
        this.mlphut = mlphut;
        this.mtiet = mtiet;
        this.cuoiky = cuoiky;
        this.tongket = tongket;
        this.term = term;
    }

    public ScoreBoard() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getMieng() {
        return mieng;
    }

    public void setMieng(double mieng) {
        this.mieng = mieng;
    }

    public double getMlphut() {
        return mlphut;
    }

    public void setMlphut(double mlphut) {
        this.mlphut = mlphut;
    }

    public double getMtiet() {
        return mtiet;
    }

    public void setMtiet(double mtiet) {
        this.mtiet = mtiet;
    }

    public double getCuoiky() {
        return cuoiky;
    }

    public void setCuoiky(double cuoiky) {
        this.cuoiky = cuoiky;
    }

    public double getTongket() {
        return tongket;
    }

    public void setTongket(double tongket) {
        this.tongket = tongket;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }


    @Override
    public String toString() {
        return "StudentMark{" +
                "idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", nameSubject='" + nameSubject + '\'' +
                ", mieng=" + mieng +
                ", mlphut=" + mlphut +
                ", mtiet=" + mtiet +
                ", cuoiky=" + cuoiky +
                ", tongket=" + tongket +
                ", term=" + term +
                '}';
    }
}
