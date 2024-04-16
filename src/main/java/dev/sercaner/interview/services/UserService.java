package dev.sercaner.interview.services;

import dev.sercaner.interview.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    User update(Long id, User user);

    Boolean deleteUser(Long id);
}
