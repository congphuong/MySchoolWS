package com.ashin.model;

/**
 * Created by trile on 6/20/2017.
 */
public class UserRegister {
    private String userName;
    private String password;
    private int verifyCode;

    public UserRegister(String userName, String password, int verifyCode) {
        this.userName = userName;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public UserRegister(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode=" + verifyCode +
                '}';
    }
}
