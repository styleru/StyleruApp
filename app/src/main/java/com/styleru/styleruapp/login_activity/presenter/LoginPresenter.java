package com.styleru.styleruapp.login_activity.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.login_activity.model.LoginInfo;
import com.styleru.styleruapp.login_activity.interfaces.LoginView;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

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
