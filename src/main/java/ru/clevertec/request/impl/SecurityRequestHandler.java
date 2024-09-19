package ru.clevertec.request.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.clevertec.model.Role;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestHandler;
import ru.clevertec.request.RequestHandlerException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Order(3)
public class SecurityRequestHandler implements RequestHandler {
    private final Map<String, List<Role>> pathRoleMap = new HashMap<>();

    {
        pathRoleMap.put("product/update", List.of(Role.ADMIN));
        pathRoleMap.put("product/create", List.of(Role.ADMIN));
        pathRoleMap.put("product/get", List.of(Role.ADMIN, Role.USER));
    }

    @Override
    public void handle(Request request) {
        String path = request.getPath();
        Role userRole = request.getUser().getRole();

        List<Role> roles = Optional.ofNullable(pathRoleMap.get(path))
                .orElseThrow(() -> new RequestHandlerException("Incorrect path"));
        boolean available = roles.stream().anyMatch(role -> role.equals(userRole));

        if (!available) {
            throw new RequestHandlerException("Forbidden");
        }


    }
}
