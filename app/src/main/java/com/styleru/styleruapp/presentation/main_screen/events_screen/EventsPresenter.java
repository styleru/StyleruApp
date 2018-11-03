package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class EventsPresenter extends MvpPresenter<EventsView> {
    private final StyleruRouter mRouter;

    @Inject
    EventsPresenter(StyleruRouter router) {
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                getViewState().onDirectionsClicked(mRouter);
                break;
            case R.id.people_menu:
                getViewState().onPeopleClicked(mRouter);
                break;
            case R.id.profile_menu:
                getViewState().onProfileClicked(mRouter);
                break;
        }
    }

    void provideData(){
        EventItem sampleProfile = new EventItem("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bufotes_oblongus.jpg/275px-Bufotes_oblongus.jpg", "java meetup", "31.12.2018", "red square");
        List<EventItem> profiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            profiles.add(sampleProfile);
        }
        getViewState().showData(profiles);
    }
}
