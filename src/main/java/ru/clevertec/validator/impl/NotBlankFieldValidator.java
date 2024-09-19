package ru.clevertec.validator.impl;

import org.springframework.stereotype.Component;
import ru.clevertec.validator.FieldValidator;
import ru.clevertec.validator.ValidatorException;
import ru.clevertec.validator.annotation.NotBlank;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Optional;

@Component
public class NotBlankFieldValidator implements FieldValidator {

    @Override
    public Optional<String> validate(Object object, Field field) {
        try {
            if (field.getType() != String.class) {
                throw new ValidatorException("Field is not String");
            }

            NotBlank annotation = field.getAnnotation(NotBlank.class);

            field.setAccessible(true);
            String value = (String) field.get(object);

            if (value == null || value.isBlank()) {
                return Optional.of(annotation.message());
            }
            return Optional.empty();
        } catch (IllegalAccessException e) {
            throw new ValidatorException("Fail check on Pattern in " + object, e);
        }

    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return NotBlank.class;
    }
}
