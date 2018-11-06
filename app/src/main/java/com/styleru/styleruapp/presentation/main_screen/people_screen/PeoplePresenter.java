package com.styleru.styleruapp.presentation.main_screen.people_screen;

import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class PeoplePresenter extends MvpPresenter<PeopleView> {
    private final StyleruRouter mRouter;
    private View.OnClickListener mOnClickListener;
    @Inject
    PeoplePresenter(StyleruRouter router){
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                getViewState().onDirectionsClicked(mRouter);
                break;
            case R.id.events_menu:
                getViewState().onEventsClicked(mRouter);
                break;
            case R.id.profile_menu:
                getViewState().onProfileClicked(mRouter, null);
                break;
        }
    }

    void onProfileClicked(String id){
        getViewState().onProfileClicked(mRouter, id);
    }

    void provideData(){
        PeopleRecyclerModel sampleProfile = new PeopleRecyclerModel("Vladimir", "Pitun", "Web","https://pp.userapi.com/c847123/v847123031/156d/kxJRy2z3nOA.jpg","ci1p24qh93rrk92k91");
        List<PeopleRecyclerModel> profiles = new ArrayList<>(Collections.nCopies(100, sampleProfile));
        getViewState().showData(profiles);
    }
}
