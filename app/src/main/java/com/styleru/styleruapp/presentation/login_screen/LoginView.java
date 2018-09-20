package com.styleru.styleruapp.presentation.login_screen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.styleru.styleruapp.domain.entity.login.LoginInfo;


public interface LoginView extends MvpView{
    @StateStrategyType(AddToEndSingleStrategy.class)
    void passData(LoginInfo loginInfo);
    //@StateStrategyType(AddToEndSingleStrategy.class)
   // void forgetPassword();
}
