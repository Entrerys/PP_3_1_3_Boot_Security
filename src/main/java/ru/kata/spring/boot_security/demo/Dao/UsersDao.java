package ru.kata.spring.boot_security.demo.Dao;

import ru.kata.spring.boot_security.demo.Model.User;

import java.util.List;

public interface UsersDao {

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    public User getUserByUsername(String username);


}
