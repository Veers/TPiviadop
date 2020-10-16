package ru.veers.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegistrationDto extends UserDto{
    @NotBlank(message = "repeat pass non empty")
    @JsonProperty("rPassword")
    private String rPassword;

    @NotBlank(message = "repeat pass non empty")
    @Email
    @JsonProperty("email")
    private String email;
}
