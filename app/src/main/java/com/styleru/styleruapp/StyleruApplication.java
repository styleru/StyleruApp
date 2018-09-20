package com.styleru.styleruapp;

import android.app.Application;

import com.styleru.styleruapp.di.AppComponent;
import com.styleru.styleruapp.di.DaggerAppComponent;

public class StyleruApplication extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        configureDagger();
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

}
