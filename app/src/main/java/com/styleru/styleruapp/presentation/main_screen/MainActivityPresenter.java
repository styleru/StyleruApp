package com.styleru.styleruapp.presentation.main_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MvpView> {
    private final StyleruRouter mRouter;
    @Inject
    MainActivityPresenter(StyleruRouter router){this.mRouter = router;}

    void changeScreen(){
        mRouter.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);
    }
}
