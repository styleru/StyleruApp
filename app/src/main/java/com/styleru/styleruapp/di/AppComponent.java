package com.styleru.styleruapp.di;

import android.content.Context;

import com.styleru.styleruapp.di.module.NavigationModule;
import com.styleru.styleruapp.di.module.NetworkModule;
import com.styleru.styleruapp.di.module.RepositoryModule;
import com.styleru.styleruapp.presentation.category_screen.ChangeCategoryActivity;
import com.styleru.styleruapp.presentation.login_screen.LoginActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NavigationModule.class, RepositoryModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(ChangeCategoryActivity changeCategoryActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}

