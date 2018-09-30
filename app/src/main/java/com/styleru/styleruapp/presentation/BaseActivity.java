package com.styleru.styleruapp.presentation;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.styleru.styleruapp.navigation.StyleruNavigator;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;

public abstract class BaseActivity extends MvpAppCompatActivity {
    @Inject
    NavigatorHolder mNavigatorHolder;

    private Navigator mNavigator;
    public BaseActivity(int containerId){
        mNavigator = new StyleruNavigator(this, containerId);
    }

    public BaseActivity(){
        this(-1);
    }

    @Override
    protected void onResume() {
        mNavigatorHolder.setNavigator(mNavigator);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mNavigatorHolder.removeNavigator();
        super.onPause();
    }
}