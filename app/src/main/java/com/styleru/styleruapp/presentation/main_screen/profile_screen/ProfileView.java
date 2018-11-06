package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.StyleruRouter;

interface ProfileView extends MvpView {
    void showData(ProfileModel profileItem);
    void onPeopleClicked(StyleruRouter router);
    void onEventsClicked(StyleruRouter router);
    void onDirectionsClicked(StyleruRouter router);
}
