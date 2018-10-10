package com.styleru.styleruapp.di.module;

import com.styleru.styleruapp.domain.repository.IUserDataApi;
import com.styleru.styleruapp.domain.repository.MockedUserDataApi;

import dagger.Binds;
import dagger.Module;

@Module
public interface UserDataApiModule {
    @Binds
    IUserDataApi bindUserDataApi(MockedUserDataApi userDataApi);
}
