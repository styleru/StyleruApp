package com.styleru.styleruapp.presentation.main_screen.people_screen;

import com.arellomobile.mvp.MvpView;
import com.styleru.styleruapp.presentation.main_screen.ProfileItem;

import java.util.List;

interface PeopleView extends MvpView {
    void showData(List<ProfileItem> items);
}
