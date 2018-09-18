package com.styleru.styleruapp.di;

import android.content.Context;

import com.styleru.styleruapp.login_activity.view.LoginActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component
public interface AppComponent {
    void inject(LoginActivity loginActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Context context);
    }

}