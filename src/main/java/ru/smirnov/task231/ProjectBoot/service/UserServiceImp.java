package ru.smirnov.task231.ProjectBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smirnov.task231.ProjectBoot.dao.UserDao;
import ru.smirnov.task231.ProjectBoot.model.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void removeUserById(final long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void updateUser(final User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(final Long id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}
