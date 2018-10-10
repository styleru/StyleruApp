package com.styleru.styleruapp.domain.repository;

import javax.inject.Inject;

public class UserDataRepository implements IUserDataRepository {
    private IUserDataApi mUserDataApi;

    @Inject
    UserDataRepository(IUserDataApi userDataApi){
        this.mUserDataApi = userDataApi;
    }

    @Override
    public boolean isInfoCorrect(String login, String password) {
        return mUserDataApi.isInfoCorrect(login, password);
    }
}
