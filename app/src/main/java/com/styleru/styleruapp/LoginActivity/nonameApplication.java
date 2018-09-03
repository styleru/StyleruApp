package com.styleru.styleruapp.LoginActivity;

import android.app.Application;

public class nonameApplication extends Application {
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
                .context(this)
                .build();
    }
}2
