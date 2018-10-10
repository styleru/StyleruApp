package com.styleru.styleruapp.data;


public interface Provider {

    interface UserDataStorage {
        Boolean isInfoCorrect(String login, String password);
    }
}