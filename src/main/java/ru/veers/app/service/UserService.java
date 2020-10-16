package ru.veers.app.service;

import ru.veers.app.model.UserDto;
import ru.veers.app.model.UserRegistrationDto;

public interface UserService {
    public void addUser(UserRegistrationDto userRegistrationDto);
    public boolean login(UserDto userDto);
}
