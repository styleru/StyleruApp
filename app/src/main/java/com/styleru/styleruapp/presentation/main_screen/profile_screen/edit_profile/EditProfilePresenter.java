package com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.domain.interactor.ProfileInteractor;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

import javax.inject.Inject;

@InjectViewState
public class EditProfilePresenter extends MvpPresenter<EditProfileView> {
    ProfileInteractor mProfileInteractor;
    StyleruRouter mRouter;
    @Inject
    EditProfilePresenter(ProfileInteractor profileInteractor, StyleruRouter router) {
        mProfileInteractor = profileInteractor;
        mRouter = router;
    }

    void provideData(){
        ProfileModel model = mProfileInteractor.getProfile("id");
        getViewState().showData(model);
    }

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
            case R.id.profile_menu:
                mRouter.replaceScreen(ScreenKeys.PROFILE_FRAGMENT);
        }
    }
}
