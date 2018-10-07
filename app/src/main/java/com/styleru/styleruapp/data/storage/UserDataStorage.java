package com.styleru.styleruapp.data.storage;

import com.styleru.styleruapp.data.Provider;

public class UserDataStorage implements Provider.UserDataStorage {
    @Override
    public Boolean isInfoCorrect(String login, String password) {
        return login.equals("guest") && password.equals("1234");
    }
}
