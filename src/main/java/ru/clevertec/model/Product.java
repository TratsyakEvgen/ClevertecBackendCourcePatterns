package ru.clevertec.model;

import lombok.Data;
import ru.clevertec.validator.annotation.NotBlank;
import ru.clevertec.validator.annotation.NotNull;

@Data
public class Product {
    @NotNull
    private final Long id;
    @NotBlank
    private final String description;
}
