package ru.clevertec.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Optional;

public interface FieldValidator {
    Optional<String> validate(Object object, Field field);

    Class<? extends Annotation> getAnnotationClass();
}
