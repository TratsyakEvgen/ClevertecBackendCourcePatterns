package ru.clevertec.request;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.model.User;
import ru.clevertec.validator.annotation.NotBlank;
import ru.clevertec.validator.annotation.NotNull;

@Data
@Builder
public class Request {
    @NotBlank
    private String path;
    @NotNull
    private Object body;
    @NotNull
    private User user;

}
