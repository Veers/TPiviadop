package ru.gnupunk.client.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gnupunk.client.entity.UserEntity;
import ru.gnupunk.client.model.request.LoginUserRequest;
import ru.gnupunk.client.model.request.RegisterUserRequest;
import ru.gnupunk.client.repository.UserRepository;
import ru.gnupunk.client.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserEntityProcessor userEntityProcessor;

    @Override
    public boolean isExistEmailInDatabase(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean isExistNameInDatabase(String email) {
        return userRepository.findByName(email).isPresent();
    }

    @Override
    public void createNewAccount(String email, String passHash) {
    }

    @Override
    @Transactional
    public UserEntity createNewAccount(RegisterUserRequest registerUserRequest) {
        Optional<UserEntity> r = userRepository.findByEmailAndName(registerUserRequest.getEmail(), registerUserRequest.getName());
        UserEntity userEntity = userEntityProcessor.createNewEntity(registerUserRequest.getEmail(), registerUserRequest.getName(), registerUserRequest.getPasswordHash());
        if (!r.isPresent()) {
            userRepository.saveAndFlush(userEntity);
            //TODO send email with confirmation
        }
        return userEntity;
    }

    @Override
    @Transactional
    public boolean login(LoginUserRequest loginUserRequest) {
        Optional<UserEntity> result = userRepository.findByEmailAndPassword(loginUserRequest.getEmail(), loginUserRequest.getPasswordHash());
        return result.isPresent();
    }
}
