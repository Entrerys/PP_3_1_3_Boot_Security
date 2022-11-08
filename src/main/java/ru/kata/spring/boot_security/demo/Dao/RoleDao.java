package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.Model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
