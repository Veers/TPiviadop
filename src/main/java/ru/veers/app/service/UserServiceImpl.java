package ru.veers.app.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.veers.app.UserValidator;
import ru.veers.app.entity.UserEntity;
import ru.veers.app.exception.DifferentPasswordException;
import ru.veers.app.model.UserDto;
import ru.veers.app.model.UserRegistrationDto;
import ru.veers.app.repository.UserRepository;

import java.util.Optional;

@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserValidator userValidator;

    @Override
    public void addUser(UserRegistrationDto userRegistrationDto) {
        UserEntity user = convertToEntity(userRegistrationDto);
        if (userValidator.validateNewUser(userRegistrationDto)) {
            userRepository.save(user);
        } else {
            throw new DifferentPasswordException("not same pass");
        }
    }

    @Override
    public boolean login(UserDto userDto) {
        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        return user.isPresent();
    }

    private UserEntity convertToEntity(UserDto userDto) {
        System.out.println("convert to: " + userDto.toString());
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        System.out.println("convert to: " + user.toString());
        return user;
    }
}
