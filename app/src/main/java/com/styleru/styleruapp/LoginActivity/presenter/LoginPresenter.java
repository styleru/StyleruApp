package com.styleru.styleruapp.LoginActivity.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.LoginActivity.model.LoginInfo;
import com.styleru.styleruapp.LoginActivity.interfaces.LoginView;

import javax.inject.Inject;

import dagger.Component;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    private final String FAKE_TOKEN = "dmef2342dmk3mda";

    @Inject
    public LoginPresenter() {
    }

    @Inject
    public boolean signIn(String login, String password){
        LoginInfo info = new LoginInfo(login, password, FAKE_TOKEN);
        boolean isSuccessful = info.getLogin().equals("guest") && info.getPassword().equals("1234"); // fake check
        if (isSuccessful){
            getViewState().passData(info);
        }
        return isSuccessful;
    }
}
