package com.styleru.styleruapp.login_activity;

import android.content.Context;

import com.styleru.styleruapp.login_activity.model.LoginInfo;
import com.styleru.styleruapp.login_activity.presenter.LoginPresenter;
import com.styleru.styleruapp.login_activity.view.LoginActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


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