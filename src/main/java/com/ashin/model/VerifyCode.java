package com.ashin.model;

/**
 * Created by trile on 6/21/2017.
 */
public class VerifyCode {
    private int verifyCode;
    private int idRole;
    private String nameRole;

    public VerifyCode(){}

    public VerifyCode(int verifyCode, int idRole, String nameRole) {
        this.verifyCode = verifyCode;
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "verifyCode=" + verifyCode +
                ", idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
