package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.Model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    List<Role> getRoles();

    public Role getRoleByName(String name);
}
