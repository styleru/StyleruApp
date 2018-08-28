package com.styleru.styleruapp.mvp.presenter;

import android.content.SharedPreferences;

import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.mvp.model.LoginInfo;
import com.styleru.styleruapp.mvp.interfaces.LoginView;
import com.styleru.styleruapp.mvp.view.LoginActivity;

public class LoginPresenter extends MvpPresenter<LoginView> {
    public static final String APP_PREFERENCES = "settings";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ACCESS_TOKEN = "token";

    public LoginPresenter() {
    }

    public void signIn(){
        LoginInfo info = getViewState().getLoginData();
        boolean isSuccessful = info.getLogin().equals("guest") && info.getPassword().equals("1234"); // fake check
        info.setToken("gfmr14n14nuib1ns19"); // fake token
        if (isSuccessful){
            getViewState().passData(info);
            getViewState().newIntent();
        }
    }
}
