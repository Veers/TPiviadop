package ru.veers.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veers.app.entity.UserEntity;
import ru.veers.app.model.UserRegistrationDto;
import ru.veers.app.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public boolean validateNewUserPassword(UserRegistrationDto userRegistrationDto) {
        return userRegistrationDto.getPassword().equals(userRegistrationDto.getRPassword());
    }

    public boolean validateNewUser(UserRegistrationDto userRegistrationDto) {
        return validateNewUserPassword(userRegistrationDto) && validateWithExistingUsers(userRegistrationDto);
    }

    private boolean validateWithExistingUsers(UserRegistrationDto userRegistrationDto) {
        Optional<UserEntity> u1 = userRepository.findByUsername(userRegistrationDto.getUsername());
        Optional<UserEntity> u2 = userRepository.findByEmail(userRegistrationDto.getEmail());
        return u1.isEmpty() && u2.isEmpty();
    }
}
