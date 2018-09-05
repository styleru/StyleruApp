package com.styleru.styleruapp.login_activity.model;

import javax.inject.Inject;

public class LoginInfo {
    private String login;
    private String password;
    private String token;
/*
    @Inject
    public LoginInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }
*/
    @Inject
    public LoginInfo(String login, String password, String token) {
        this.login = login;
        this.password = password;
        this.token = token;
    }
    @Inject
    public String getLogin() {
        return login;
    }
    @Inject
    public void setLogin(String login) {
        this.login = login;
    }
    @Inject
    public String getPassword() {
        return password;
    }
    @Inject
    public void setPassword(String password) {
        this.password = password;
    }
    @Inject
    public String getToken() {
        return token;
    }
    @Inject
    public void setToken(String token) {
        this.token = token;
    }
}
