package com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

interface EditProfileView extends MvpView {
    void showData(ProfileModel model);
}
