package com.styleru.styleruapp.domain.interactor;

import com.styleru.styleruapp.domain.repository.IUserDataRepository;

import javax.inject.Inject;

public class AuthorizationInteractor{
    public IUserDataRepository mUserDataRepository;
    @Inject
    AuthorizationInteractor(IUserDataRepository userDataRepository){
        this.mUserDataRepository = userDataRepository;
    }

    public boolean isInfoCorrect(String login, String password) {
        return mUserDataRepository.isInfoCorrect(login, password);
    }
}
