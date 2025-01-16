package ru.smirnov.task231.ProjectBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.task231.ProjectBoot.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void removeUserById(final long id) {
        final User user = getUserById(id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void updateUser(final User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(final Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
