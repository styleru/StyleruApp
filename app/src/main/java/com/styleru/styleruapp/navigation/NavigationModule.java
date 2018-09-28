package com.styleru.styleruapp.navigation;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public final class NavigationModule {
    private Cicerone<StyleruRouter> mCicerone;

    public NavigationModule(){
        mCicerone = Cicerone.create(new StyleruRouter());
    }

    @Provides
    Router provideRouter(){
        return mCicerone.getRouter();
    }

    @Provides
    NavigatorHolder provideNavigatorHolder(){
        return mCicerone.getNavigatorHolder();
    }
}
