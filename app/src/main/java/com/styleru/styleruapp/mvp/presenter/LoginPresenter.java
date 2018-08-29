package com.styleru.styleruapp.mvp.presenter;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.mvp.model.LoginInfo;
import com.styleru.styleruapp.mvp.interfaces.LoginView;
import com.styleru.styleruapp.mvp.view.LoginActivity;

import javax.inject.Inject;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    @Inject
    public LoginPresenter() {
    }

    public boolean signIn(String login, String password){
        LoginInfo info = new LoginInfo(login, password);
        boolean isSuccessful = info.getLogin().equals("guest") && info.getPassword().equals("1234"); // fake check
        info.setToken("gfmr14n14nuib1ns19"); // fake token
        if (isSuccessful){
            getViewState().passData(info);
        }
        return isSuccessful;
    }
}
