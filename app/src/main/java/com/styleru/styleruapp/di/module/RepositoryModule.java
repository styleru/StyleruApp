package com.styleru.styleruapp.di.module;

import com.styleru.styleruapp.domain.repository.IUserDataRepository;
import com.styleru.styleruapp.domain.repository.UserDataRepository;

import dagger.Binds;
import dagger.Module;

@Module(includes = StorageModule.class)
public interface RepositoryModule {
    @Binds
    IUserDataRepository bindUserDataRepository(UserDataRepository userDataRepository);
}
