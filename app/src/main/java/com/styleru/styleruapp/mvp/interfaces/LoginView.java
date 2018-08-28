package com.styleru.styleruapp.mvp.interfaces;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.mvp.model.LoginInfo;

public interface LoginView extends MvpView{
    void newIntent();
    LoginInfo getLoginData();
    void passData(LoginInfo loginInfo);
    void forgetPassword();
}
