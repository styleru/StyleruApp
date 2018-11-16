package com.styleru.styleruapp.domain.repository;

import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

public interface IUserDataRepository {
    boolean isInfoCorrect(String login, String password);
    ProfileModel getProfile(String id);
}
