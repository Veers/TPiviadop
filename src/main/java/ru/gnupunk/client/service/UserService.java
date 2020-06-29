package ru.gnupunk.client.service;

import ru.gnupunk.client.entity.UserEntity;
import ru.gnupunk.client.model.request.RegisterUserRequest;

public interface UserService {
    public boolean isExistEmailInDatabase(String email);

    boolean isExistNameInDatabase(String email);

    void createNewAccount(String email, String passHash);

    UserEntity createNewAccount(RegisterUserRequest registerUserRequest);
}
