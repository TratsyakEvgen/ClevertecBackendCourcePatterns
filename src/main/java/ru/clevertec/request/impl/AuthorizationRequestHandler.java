package ru.clevertec.request.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.clevertec.model.User;
import ru.clevertec.repository.UserRepository;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestHandler;
import ru.clevertec.request.RequestHandlerException;

@Component
@Order(2)
@RequiredArgsConstructor
public class AuthorizationRequestHandler implements RequestHandler {
    private final UserRepository userRepository;

    @Override
    public void handle(Request request) {
        User requestUser = request.getUser();
        String login = requestUser.getLogin();
        String password = requestUser.getPassword();

        User repositoryUser = userRepository.findByLogin(login)
                .orElseThrow(() -> new RequestHandlerException("Incorrect login"));

        if (!password.equals(repositoryUser.getPassword())) {
            throw new RequestHandlerException("Incorrect password");
        }

        request.setUser(repositoryUser);
    }
}
