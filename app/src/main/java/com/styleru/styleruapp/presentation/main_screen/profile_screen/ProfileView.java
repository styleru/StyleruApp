package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import com.arellomobile.mvp.MvpView;

import java.util.List;

interface ProfileView extends MvpView {
    void showData(ProfileItem profileItem, List<LinkItem> links);
}
