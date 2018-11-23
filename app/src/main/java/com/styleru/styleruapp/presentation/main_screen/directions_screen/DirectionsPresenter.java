package com.styleru.styleruapp.presentation.main_screen.directions_screen;


import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public final class DirectionsPresenter extends MvpPresenter<DirectionsView> {
    private final StyleruRouter mRouter;
    private final String CATEGORIES[] = {"Android", "IOS", "Web", "Design", "Digital marketing", "Game Dev"};
    @Inject
    DirectionsPresenter(StyleruRouter router) {
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.people_menu:
                getViewState().onPeopleClicked(mRouter);
                break;
            case R.id.events_menu:
                getViewState().onEventsClicked(mRouter);
                break;
            case R.id.profile_menu:
                getViewState().onProfileClicked(mRouter);
                break;
        }
    }

    void provideData(){
        List<DirectionsItem> items = new ArrayList<>();
        for (String element:
                CATEGORIES) {
            DirectionsItem item = new DirectionsItem(element);
            items.add(item);
        }
        getViewState().showData(items);
    }

}
