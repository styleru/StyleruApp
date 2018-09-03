package com.styleru.styleruapp.LoginActivity.model;

import javax.inject.Inject;

import dagger.Module;

@Module
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
