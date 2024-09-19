package ru.clevertec.request.command;

import ru.clevertec.request.Request;

public interface RequestCommand {
    void execute(Request request);

    String getPath();
}
