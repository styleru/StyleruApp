package com.styleru.styleruapp.presentation.login_screen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruNavigator;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@InjectViewState
public final class LoginPresenter extends MvpPresenter<LoginView> {
    private final String FAKE_TOKEN = "dmef2342dmk3mda";
    private StyleruNavigator mNavigator;
    private StyleruRouter mRouter;
    @Inject
    LoginPresenter(StyleruRouter router) {
        this.mRouter = router;
    }


    void signIn(AppCompatActivity context, String login, String password){
        boolean isSuccessful = login.equals("guest") && password.equals("1234"); // fake check
        if (isSuccessful){
            mNavigator = new StyleruNavigator(context, -1);
            mNavigator.createActivityIntent(context, ScreenKeys.CATEGORY_ACTIVITY, null);
            StyleruApplication.getNavigationHolder().setNavigator(mNavigator);
            StyleruApplication.getRouter().navigateTo(ScreenKeys.CATEGORY_ACTIVITY);
        }
    }
}
