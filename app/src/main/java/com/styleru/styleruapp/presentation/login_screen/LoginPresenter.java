package com.styleru.styleruapp.presentation.login_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public final class LoginPresenter extends MvpPresenter<LoginView> {
    private final String FAKE_TOKEN = "dmef2342dmk3mda";

    @Inject
    public LoginPresenter() {
    }
/*
//error here
    @Inject
    public boolean signIn(String login, String password){
        LoginInfo info = new LoginInfo(login, password, FAKE_TOKEN);
        boolean isSuccessful = info.getLogin().equals("guest") && info.getPassword().equals("1234"); // fake check
        if (isSuccessful){
            getViewState().passData(info);
        }
        return isSuccessful;
    }
    */
}
