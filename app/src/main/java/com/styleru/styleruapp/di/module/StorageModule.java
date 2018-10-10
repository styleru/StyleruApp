package com.styleru.styleruapp.di.module;

import com.styleru.styleruapp.data.Provider;
import com.styleru.styleruapp.data.storage.UserDataStorage;

import dagger.Binds;
import dagger.Module;

@Module
public interface StorageModule {
    @Binds
    Provider.UserDataStorage bindUserDataStorage(UserDataStorage userDataStorage);
}
