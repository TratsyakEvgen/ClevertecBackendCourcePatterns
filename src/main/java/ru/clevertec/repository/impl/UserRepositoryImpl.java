package ru.clevertec.repository.impl;

import org.springframework.stereotype.Repository;
import ru.clevertec.model.Role;
import ru.clevertec.model.User;
import ru.clevertec.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> users;

    {
        users = new HashMap<>();
        users.put("admin", User.builder().login("admin").password("admin").role(Role.ADMIN).build());
        users.put("user", User.builder().login("user").password("user").role(Role.USER).build());
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(users.get(login));
    }
}
