package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final StyleruRouter mRouter;

    @Inject ProfilePresenter(StyleruRouter router) { this.mRouter = router;}

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                getViewState().onDirectionsClicked(mRouter);
                break;
            case R.id.events_menu:
                getViewState().onEventsClicked(mRouter);
                break;
            case R.id.people_menu:
                getViewState().onPeopleClicked(mRouter);
                break;
        }
    }

    void provideData(){
        List<LinkItem> links = new ArrayList<>();
        links.add(new LinkItem("VK", "id4920"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));

        ProfileModel sampleProfile = new ProfileModel("Vlad","Yundin",
                "Android",
                "https://pp.userapi.com/c836234/v836234471/2fc01/CfB0TIHo8zE.jpg?ava=1",
                "ci1p24qh93rrk92k91",
                "null@gmail.com",
                "88005553535",
                links);
        getViewState().showData(sampleProfile);
    }
}
