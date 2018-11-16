package com.styleru.styleruapp.domain.repository;

import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

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

    @Override
    public ProfileModel getProfile(String id) {
        return mUserDataApi.getProfile("id");
    }


}
