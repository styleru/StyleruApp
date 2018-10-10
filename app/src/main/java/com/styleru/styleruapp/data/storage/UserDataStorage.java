package com.styleru.styleruapp.data.storage;

import com.styleru.styleruapp.data.Provider;

import javax.inject.Inject;


public class UserDataStorage implements Provider.UserDataStorage {
    @Inject
    UserDataStorage(){

    }
    @Override
    public Boolean isInfoCorrect(String login, String password) {
        return login.equals("guest") && password.equals("1234");
    }
}
