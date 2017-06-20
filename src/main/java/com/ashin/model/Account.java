package com.ashin.model;

/**
 * Created by Khuong on 2017-06-05.
 */
public class Account {
    String username, password, role, idrole, token;

    public Account() {

    }

    public Account(String username, String password, String role, String idrole, String token) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.idrole = idrole;
        this.token = token;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIdrole() {
        return idrole;
    }

    public void setIdrole(String idrole) {
        this.idrole = idrole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
