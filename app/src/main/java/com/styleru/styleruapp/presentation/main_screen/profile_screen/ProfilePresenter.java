package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

class ProfilePresenter extends MvpPresenter<ProfileView> {
    private StyleruRouter mRouter;

    @Inject ProfilePresenter(StyleruRouter router) { this.mRouter = router;}

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                mRouter.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);
                break;
            case R.id.events_menu:
                mRouter.replaceScreen(ScreenKeys.EVENTS_FRAGMENT);
                break;
            case R.id.people_menu:
                mRouter.replaceScreen(ScreenKeys.PEOPLE_FRAGMENT);
                break;
        }
    }
}
