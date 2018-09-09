package com.styleru.styleruapp.login_activity;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;

public class StyleruApplication extends Application {
    private static AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }
    public static StyleruApplication INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        configureDagger();
        INSTANCE = this;
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

}
