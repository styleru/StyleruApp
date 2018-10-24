package com.styleru.styleruapp.di;

import android.content.Context;

import com.styleru.styleruapp.di.module.NavigationModule;
import com.styleru.styleruapp.di.module.NetworkModule;
import com.styleru.styleruapp.di.module.RepositoryModule;
import com.styleru.styleruapp.presentation.login_screen.LoginActivity;
import com.styleru.styleruapp.presentation.main_screen.MainActivity;
import com.styleru.styleruapp.presentation.main_screen.directions_screen.DirectionsFragment;
import com.styleru.styleruapp.presentation.main_screen.events_screen.EventsFragment;
import com.styleru.styleruapp.presentation.main_screen.people_screen.PeopleFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NavigationModule.class, RepositoryModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
    void inject(DirectionsFragment directionsFragment);
    void inject(EventsFragment eventsFragment);
    void inject(PeopleFragment peopleFragment);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}

