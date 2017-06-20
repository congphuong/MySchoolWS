package com.ashin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khuong on 2017-06-05.
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String chucVu;
    private int maChucVu;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    ;

    public User(String username, String password, String chucVu, int maChucVu) {
        this.username = username;
        this.password = password;
        this.chucVu = chucVu;
        this.maChucVu = maChucVu;
    }

    public User(int userId, String username, String password, String chucVu, int maChucVu) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.chucVu = chucVu;
        this.maChucVu = maChucVu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public List<String> getAuthorities() {
        List<String> ar = new ArrayList<>();
        ar.add("ROLE_" + chucVu);
        return ar;
    }

    public boolean getEnabled() {
        return true;
    }
}
