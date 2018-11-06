package com.styleru.styleruapp.presentation.main_screen.people_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.List;

interface PeopleView extends MvpView {
    void showData(List<PeopleRecyclerModel> items);
    void onEventsClicked(StyleruRouter router);
    void onProfileClicked(StyleruRouter router, Object data);
    void onDirectionsClicked(StyleruRouter router);
}
