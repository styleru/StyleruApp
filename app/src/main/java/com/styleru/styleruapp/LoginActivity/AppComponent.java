package com.styleru.styleruapp.LoginActivity;

import android.content.Context;

import com.styleru.styleruapp.LoginActivity.view.LoginActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
public interface AppComponent {
    void inject(LoginActivity loginActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
2