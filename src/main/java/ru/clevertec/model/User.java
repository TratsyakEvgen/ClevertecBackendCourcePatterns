package ru.clevertec.model;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.validator.annotation.NotBlank;
import ru.clevertec.validator.annotation.NotNull;

@Data
@Builder
public class User {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotNull
    private Role role;
}
