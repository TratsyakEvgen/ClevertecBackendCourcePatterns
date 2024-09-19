package ru.clevertec.request.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestChainExecutor;
import ru.clevertec.request.RequestHandler;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestChainExecutorImpl implements RequestChainExecutor {
    private final List<RequestHandler> requestHandlers;

    @Override
    public void execute(Request request) {
        requestHandlers.forEach(requestHandler -> requestHandler.handle(request));
    }
}
