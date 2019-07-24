package com.styleru.styleruapp.domain.interactor;

import com.styleru.styleruapp.domain.repository.IUserDataRepository;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

import javax.inject.Inject;

public class ProfileInteractor {
    public IUserDataRepository mRepository;
    @Inject
    ProfileInteractor(IUserDataRepository repository){
        this.mRepository = repository;
    }

    public ProfileModel getProfile(String id) {
        return mRepository.getProfile("id");
    }

}
