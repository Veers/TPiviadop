package ru.gnupunk.client.network.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gnupunk.client.model.request.RegisterUserRequest;
import ru.gnupunk.client.service.UserService;

@RestController
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/forgot")
    public String forgotData() {
        return "forgot";
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        logger.info("email: " + registerUserRequest.getEmail() + " pass: " + registerUserRequest.getPasswordHash());
        userService.createNewAccount(registerUserRequest);
        return ResponseEntity.ok()
                .body("Year of birth cannot be in the future");
    }

    public boolean checkEmail(String email) {
        return userService.isExistEmailInDatabase(email);
    }
}
