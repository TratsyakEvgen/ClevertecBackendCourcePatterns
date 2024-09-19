package ru.clevertec.repository;

import ru.clevertec.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByLogin(String login);
}
