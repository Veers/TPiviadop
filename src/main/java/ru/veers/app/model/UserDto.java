package ru.veers.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
public class UserDto {
    @NotBlank(message = "username non empty")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "pass non empty")
    @JsonProperty("password")
    private String password;
}
