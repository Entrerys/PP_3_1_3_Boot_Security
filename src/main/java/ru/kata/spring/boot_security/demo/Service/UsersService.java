package ru.kata.spring.boot_security.demo.Service;



import ru.kata.spring.boot_security.demo.Model.User;

import java.util.List;

public interface UsersService {

    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void removeUserById(int id);

    User getUserByUsername( String username);
}
