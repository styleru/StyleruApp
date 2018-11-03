package com.styleru.styleruapp.presentation.main_screen.events_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.List;


interface EventsView extends MvpView{
    void showData(List<EventItem> items);
    void onPeopleClicked(StyleruRouter router);
    void onProfileClicked(StyleruRouter router);
    void onDirectionsClicked(StyleruRouter router);
}
