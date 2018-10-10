package com.styleru.styleruapp.domain.repository;

import com.styleru.styleruapp.data.Provider;

import javax.inject.Inject;

public class UserDataRepository implements IUserDataRepository {
    public Provider.UserDataStorage mUserDataStorage;

    @Inject
    UserDataRepository(Provider.UserDataStorage userDataStorage){
        this.mUserDataStorage = userDataStorage;
    }

    @Override
    public boolean isInfoCorrect(String login, String password) {
        return mUserDataStorage.isInfoCorrect(login, password);
    }
}
