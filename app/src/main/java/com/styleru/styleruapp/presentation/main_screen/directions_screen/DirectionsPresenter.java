package com.styleru.styleruapp.presentation.main_screen.directions_screen;


import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public final class DirectionsPresenter extends MvpPresenter<DirectionsView> {
    StyleruRouter mRouter;
    @Inject
    DirectionsPresenter(StyleruRouter router){
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.people_menu:
                mRouter.navigateTo(ScreenKeys.PEOPLE_FRAGMENT);
                break;
            case R.id.events_menu:
                mRouter.navigateTo(ScreenKeys.EVENTS_FRAGMENT);
                break;
            case R.id.profile_menu:
                mRouter.navigateTo(ScreenKeys.PROFILE_FRAGMENT);
                break;
        }
    }

}
