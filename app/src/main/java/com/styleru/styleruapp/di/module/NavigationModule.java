package com.styleru.styleruapp.di.module;

import com.styleru.styleruapp.navigation.StyleruRouter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;

@Module
public final class NavigationModule {
    private Cicerone<StyleruRouter> mCicerone;

    public NavigationModule(){
        mCicerone = Cicerone.create(new StyleruRouter());
    }

    @Provides
    StyleruRouter provideRouter(){
        return mCicerone.getRouter();
    }

    @Provides
    NavigatorHolder provideNavigatorHolder(){
        return mCicerone.getNavigatorHolder();
    }
}
