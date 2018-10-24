package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

class EventsPresenter extends MvpPresenter<EventsView> {
    StyleruRouter mRouter;

    @Inject
    EventsPresenter(StyleruRouter router) {
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                mRouter.navigateTo(ScreenKeys.DIRECTIONS_FRAGMENT);
                break;
            case R.id.people_menu:
                mRouter.navigateTo(ScreenKeys.PEOPLE_FRAGMENT);
                break;
            case R.id.profile_menu:
                break;
        }
    }
}
