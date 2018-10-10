package com.styleru.styleruapp.domain.repository;

import javax.inject.Inject;

public class MockedUserDataApi implements IUserDataApi{
    @Inject
    MockedUserDataApi(){}

    @Override
    public boolean isInfoCorrect(String login, String password) {
        return login.equals("guest") && password.equals("1234");
    }
}
