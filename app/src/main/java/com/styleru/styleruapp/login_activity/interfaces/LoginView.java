package com.styleru.styleruapp.login_activity.interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.styleru.styleruapp.login_activity.model.LoginInfo;

import dagger.Component;
import dagger.Module;
import dagger.Provides;


public interface LoginView extends MvpView{
    @StateStrategyType(AddToEndSingleStrategy.class)
    void passData(LoginInfo loginInfo);
    //@StateStrategyType(AddToEndSingleStrategy.class)
   // void forgetPassword();
}
