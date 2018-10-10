package com.styleru.styleruapp.domain.repository;

public interface IUserDataRepository {
    boolean isInfoCorrect(String login, String password);
}
