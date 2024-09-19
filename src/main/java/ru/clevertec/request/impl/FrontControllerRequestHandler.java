package ru.clevertec.request.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestHandler;
import ru.clevertec.request.command.RequestCommand;

import java.util.List;

@Component
@Order(4)
@RequiredArgsConstructor
public class FrontControllerRequestHandler implements RequestHandler {
    private final List<RequestCommand> requestCommands;

    @Override
    public void handle(Request request) {
        requestCommands.stream()
                .filter(requestCommand -> requestCommand.getPath().equals(request.getPath()))
                .forEach(requestCommand -> requestCommand.execute(request));
    }
}
