package ru.clevertec.validator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.validator.FieldValidator;
import ru.clevertec.validator.Validator;
import ru.clevertec.validator.ValidatorException;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ValidatorImpl implements Validator {

    private final List<FieldValidator> fieldValidators;

    @Override
    public void validate(Object object) {
        if (object == null) {
            throw new ValidatorException("Object is null");
        }

        List<String> errorMessages = new ArrayList<>();

        Arrays.stream(object.getClass().getDeclaredFields()).forEach(field ->
                Arrays.stream(field.getDeclaredAnnotations()).forEach(annotation ->
                        getAnnotationValidator(annotation.annotationType())
                                .flatMap(fieldValidator -> fieldValidator.validate(object, field))
                                .ifPresent(errorMessages::add)
                )
        );

        if (!errorMessages.isEmpty()) {
            throw new ValidatorException("Object is not valid " + object, errorMessages);
        }

    }

    private Optional<FieldValidator> getAnnotationValidator(Class<? extends Annotation> annotaionClass) {
        return fieldValidators.stream()
                .filter(fieldValidator -> fieldValidator.getAnnotationClass() == annotaionClass)
                .findFirst();
    }
}
