package ru.clevertec.validator.impl;

import org.springframework.stereotype.Component;
import ru.clevertec.validator.FieldValidator;
import ru.clevertec.validator.ValidatorException;
import ru.clevertec.validator.annotation.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Optional;

@Component
public class NotNullFieldValidator implements FieldValidator {
    @Override
    public Optional<String> validate(Object object, Field field) {
        try {
            NotNull annotation = field.getAnnotation(NotNull.class);

            field.setAccessible(true);
            Object value = field.get(object);

            if (value == null) {
                return Optional.of(annotation.message());
            }
            return Optional.empty();
        } catch (IllegalAccessException e) {
            throw new ValidatorException("Fail check on Pattern in " + object, e);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return NotNull.class;
    }
}
