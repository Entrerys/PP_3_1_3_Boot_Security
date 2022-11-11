package ru.kata.spring.boot_security.demo.Service;

import ru.kata.spring.boot_security.demo.Model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> getRoles();

    Role getRoleByName(String name);
}
