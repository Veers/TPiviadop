package ru.gnupunk.client.service.implementation;

import org.springframework.stereotype.Component;
import ru.gnupunk.client.entity.UserEntity;

@Component
public class UserEntityProcessor {
    public UserEntity createNewEntity(String email, String name, String passHash) {
        UserEntity ue = new UserEntity();
        ue.setEmail(email);
        ue.setName(name);
        ue.setPassword(passHash);
        ue.setActive(false);
        ue.setArchive(false);
        return ue;
    }
}
