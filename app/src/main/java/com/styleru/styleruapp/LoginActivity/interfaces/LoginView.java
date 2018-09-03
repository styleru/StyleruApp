package com.styleru.styleruapp.LoginActivity.interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.styleru.styleruapp.LoginActivity.model.LoginInfo;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Component(modules = {LoginInfo.class})
public interface LoginView extends MvpView{
    @StateStrategyType(AddToEndSingleStrategy.class)
    void passData(LoginInfo loginInfo);
    //@StateStrategyType(AddToEndSingleStrategy.class)
   // void forgetPassword();
}
