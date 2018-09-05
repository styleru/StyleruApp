package com.styleru.styleruapp.login_activity;

import android.app.Application;

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
                .context(this)
                .build();
    }
}
