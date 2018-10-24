package com.styleru.styleruapp.presentation.main_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MvpView> {
    StyleruRouter mRouter;
    @Inject
    MainActivityPresenter(StyleruRouter router){this.mRouter = router;}

    void changeScreen(String key){
        switch (key) {
            case ScreenKeys.DIRECTIONS_FRAGMENT:
                mRouter.navigateTo(ScreenKeys.DIRECTIONS_FRAGMENT);
                break;
            case ScreenKeys.EVENTS_FRAGMENT:
                mRouter.navigateTo(ScreenKeys.EVENTS_FRAGMENT);
                break;
        }

    }
}
