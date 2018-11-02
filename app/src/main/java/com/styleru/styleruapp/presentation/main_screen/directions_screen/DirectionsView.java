package com.styleru.styleruapp.presentation.main_screen.directions_screen;

import com.arellomobile.mvp.MvpView;

import java.util.List;

interface DirectionsView extends MvpView {
    void showData(List<DirectionsItem> items);
}
