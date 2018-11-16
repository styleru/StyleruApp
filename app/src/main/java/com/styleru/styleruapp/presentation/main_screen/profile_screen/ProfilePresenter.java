package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.domain.interactor.ProfileInteractor;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final StyleruRouter mRouter;
    private final ProfileInteractor mProfileInteractor;
    private ProfileModel mSampleProfile;

    @Inject ProfilePresenter(StyleruRouter router, ProfileInteractor interactor) {
        this.mRouter = router;
        this.mProfileInteractor = interactor;
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
            case R.id.edit_menu_button:
                mRouter.navigateTo(ScreenKeys.EDIT_PROFILE_FRAGMENT, mSampleProfile.getID());
                break;
        }
    }

    void provideData(){
        mSampleProfile = mProfileInteractor.getProfile("id");
        getViewState().showData(mSampleProfile);
    }
}
