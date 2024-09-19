package ru.clevertec.validator;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidatorException extends RuntimeException {
    private List<String> errorMessages;

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorException(String message, List<String> errorMessages) {
        super(message);
        this.errorMessages = errorMessages;
    }
}
