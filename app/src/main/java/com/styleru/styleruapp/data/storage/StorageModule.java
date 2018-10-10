package com.styleru.styleruapp.data.storage;

import com.styleru.styleruapp.data.Provider;

import dagger.Binds;
import dagger.Module;

@Module
public interface StorageModule {
    @Binds
    Provider.UserDataStorage bindUserDataStorage(UserDataStorage userDataStorage);
}
