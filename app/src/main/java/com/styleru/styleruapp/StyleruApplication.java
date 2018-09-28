package com.styleru.styleruapp;

import android.app.Application;

import com.styleru.styleruapp.di.AppComponent;
import com.styleru.styleruapp.di.DaggerAppComponent;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class StyleruApplication extends Application {
    private static AppComponent appComponent;
    private static Cicerone<Router> mCicerone;
    public static AppComponent getAppComponent() {
        return appComponent;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        configureDagger();
        mCicerone.create();
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

    public static NavigatorHolder getNavigationHolder(){
        return mCicerone.getNavigatorHolder();
    }

    public static Router getRouter(){
        return mCicerone.getRouter();
    }
}
