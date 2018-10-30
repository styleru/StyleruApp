package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.presentation.main_screen.ProfileItem;

import java.util.HashMap;

interface ProfileView extends MvpView {
    void showData(ProfileItem profileItem, HashMap<String, String> links);
}
