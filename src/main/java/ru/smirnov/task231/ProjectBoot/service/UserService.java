package ru.smirnov.task231.ProjectBoot.service;


import ru.smirnov.task231.ProjectBoot.model.User;

import java.util.List;

public interface UserService {
    void removeUserById(long id);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
