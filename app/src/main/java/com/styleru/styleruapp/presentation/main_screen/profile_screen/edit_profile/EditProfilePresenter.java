package com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.domain.interactor.ProfileInteractor;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

import javax.inject.Inject;

@InjectViewState
public class EditProfilePresenter extends MvpPresenter<EditProfileView> {
    ProfileInteractor mProfileInteractor;
    @Inject
    EditProfilePresenter(ProfileInteractor profileInteractor) {
        mProfileInteractor = profileInteractor;
    }

    void provideData(){
        ProfileModel model = mProfileInteractor.getProfile("id");
        getViewState().showData(model);
    }
}
