package ru.smirnov.task231.ProjectBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.smirnov.task231.ProjectBoot.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void removeUserById(final long id) {
        final User user = getUserById(id);
        entityManager.remove(user);
    }

    @Override
    public void saveUser(final User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(final User user) {
        final User userUpdate = entityManager.find(User.class, user.getId());
        if (userUpdate == null) {
            throw new EntityNotFoundException("Cannot update user. User with id: " + user.getId() + " not found");
        }
        entityManager.merge(user);
    }


    @Override
    public User getUserById(final Long id) {
        final User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Cannot get user. User with id: " + id + " not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
