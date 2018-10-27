package com.styleru.styleruapp.presentation.login_screen;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.domain.interactor.AuthorizationInteractor;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public final class LoginPresenter extends MvpPresenter<LoginView> {
    private final StyleruRouter mRouter;
    private AuthorizationInteractor mInteractor;
    @Inject
    LoginPresenter(StyleruRouter router, AuthorizationInteractor interactor) {
        this.mRouter = router;
        this.mInteractor = interactor;
    }

    void signIn(String login, String password){
        boolean isSuccessful = mInteractor.isInfoCorrect(login, password); // fake check
        if (isSuccessful){
            mRouter.navigateTo(ScreenKeys.MAIN_ACTIVITY);
        }
    }
}
