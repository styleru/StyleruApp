package com.styleru.styleruapp.presentation.main_screen.people_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.StyleruRouter;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class PeoplePresenter extends MvpPresenter<PeopleView> {
    private final StyleruRouter mRouter;

    @Inject
    PeoplePresenter(StyleruRouter router){
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                getViewState().onDirectionsClicked(mRouter);
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
        ProfileItem sampleProfile = new ProfileItem("dolphin", "web", "https://pp.userapi.com/c847123/v847123031/156d/kxJRy2z3nOA.jpg");
        List<ProfileItem> profiles = new ArrayList<>(Collections.nCopies(100, sampleProfile));
        getViewState().showData(profiles);
    }
}
