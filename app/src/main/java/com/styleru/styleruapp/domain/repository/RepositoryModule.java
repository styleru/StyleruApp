package com.styleru.styleruapp.domain.repository;

import com.styleru.styleruapp.data.storage.StorageModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = StorageModule.class)
public interface RepositoryModule {
    @Binds
    IUserDataRepository bindUserDataRepository(UserDataRepository userDataRepository);
}
