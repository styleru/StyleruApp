package com.styleru.styleruapp.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.styleru.styleruapp.presentation.main_screen.MainActivity;
import com.styleru.styleruapp.presentation.main_screen.directions_screen.DirectionsFragment;
import com.styleru.styleruapp.presentation.main_screen.events_screen.EventsFragment;
import com.styleru.styleruapp.presentation.main_screen.events_screen.ParticularEventFragment;
import com.styleru.styleruapp.presentation.main_screen.people_screen.PeopleFragment;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileFragment;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile.EditProfileFragment;

import ru.terrakok.cicerone.android.SupportAppNavigator;

public class StyleruNavigator extends SupportAppNavigator{
    public static final String ID = "id";

    public StyleruNavigator(FragmentActivity activity, int containerId) {
        super(activity, containerId);
    }


    @Override
    public Intent createActivityIntent(Context context, String screenKey, Object data) {
        Intent intent = null;
        switch (screenKey){
            case ScreenKeys.MAIN_ACTIVITY:
                intent =  new Intent(context, MainActivity.class);
                break;
        }
        return intent;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey){
            case ScreenKeys.DIRECTIONS_FRAGMENT:
                return new DirectionsFragment();
            case ScreenKeys.EVENTS_FRAGMENT:
                return new EventsFragment();
            case ScreenKeys.PEOPLE_FRAGMENT:
                return new PeopleFragment();
            case ScreenKeys.PROFILE_FRAGMENT:
                Bundle bundle = new Bundle();
                bundle.putString(ID, (String)data);
                Fragment fragment = new ProfileFragment();
                fragment.setArguments(bundle);
                return fragment;
            case ScreenKeys.EDIT_PROFILE_FRAGMENT:
                Bundle editBundle = new Bundle();
                editBundle.putString(ID, "id");
                Fragment editProfileFragment = new EditProfileFragment();
                editProfileFragment.setArguments(editBundle);
                return editProfileFragment;
            case ScreenKeys.PARTICULAR_EVENT:
                return new ParticularEventFragment();
        }
        return null;
    }
}
