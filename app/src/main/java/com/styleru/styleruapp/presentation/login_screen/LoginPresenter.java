package com.styleru.styleruapp.presentation.login_screen;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.data.Provider;
import com.styleru.styleruapp.data.storage.UserDataStorage;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public final class LoginPresenter extends MvpPresenter<LoginView> {
    private final String FAKE_TOKEN = "dmef2342dmk3mda";
    private final StyleruRouter mRouter;
    private Provider.UserDataStorage mUserDataStorage;
    @Inject
    LoginPresenter(StyleruRouter router) {
        this.mRouter = router;
        mUserDataStorage = new UserDataStorage();
    }


    void signIn(String login, String password){
        boolean isSuccessful = mUserDataStorage.isInfoCorrect("guest", "1234"); // fake check
        if (isSuccessful){
            mRouter.navigateTo(ScreenKeys.CATEGORY_ACTIVITY);
        }
    }
}
