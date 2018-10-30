package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;
import com.styleru.styleruapp.presentation.main_screen.ProfileItem;

import java.util.HashMap;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final StyleruRouter mRouter;

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

    void provideData(){
        HashMap<String, String> links = new HashMap<>();
        links.put("VK", "id4920");
        links.put("Instagram", "ngneecwmk.com");
        links.put("лицокнига", "navalnyi2018.com");

        ProfileItem sampleProfile = new ProfileItem("Vlad","Yundin",
                "Android",
                "null@gmail.com",
                "88005553535",
                "https://pp.userapi.com/c836234/v836234471/2fc01/CfB0TIHo8zE.jpg?ava=1",
                links);
        getViewState().showData(sampleProfile, links);
    }
}
