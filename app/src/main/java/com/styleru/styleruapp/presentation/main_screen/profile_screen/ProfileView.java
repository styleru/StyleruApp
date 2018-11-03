package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.List;

interface ProfileView extends MvpView {
    void showData(ProfileItem profileItem, List<LinkItem> links);
    void onPeopleClicked(StyleruRouter router);
    void onEventsClicked(StyleruRouter router);
    void onDirectionsClicked(StyleruRouter router);
}
