package com.styleru.styleruapp.presentation.login_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public final class LoginPresenter extends MvpPresenter<LoginView> {
    private final String FAKE_TOKEN = "dmef2342dmk3mda";

    @Inject
    LoginPresenter() {
    }

    void signIn(String login, String password){
        boolean isSuccessful = login.equals("guest") && password.equals("1234"); // fake check
        if (isSuccessful){
            // cicerone here
        }
    }
}
