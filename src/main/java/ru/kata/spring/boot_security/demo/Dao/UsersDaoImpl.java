package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.Model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = entityManager.createQuery("from User", User.class).getResultList();
        return list;
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }


    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();

    }

}
