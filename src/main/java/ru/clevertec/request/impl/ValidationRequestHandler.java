package ru.clevertec.request.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestHandler;
import ru.clevertec.validator.Validator;

@Component
@Order(1)
@RequiredArgsConstructor
public class ValidationRequestHandler implements RequestHandler {
    private final Validator validator;

    @Override
    public void handle(Request request) {
        validator.validate(request);
        validator.validate(request.getUser());
    }
}
