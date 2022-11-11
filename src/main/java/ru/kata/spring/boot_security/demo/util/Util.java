package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Model.Role;
import ru.kata.spring.boot_security.demo.Model.User;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UsersService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Util {

    private final RoleService roleService;
    private final UsersService usersService;
    final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public Util(RoleService roleService, UsersService usersService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleService = roleService;
        this.usersService = usersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    public void initialization() {
        Role user1 = new Role("ROLE_USER");
        Role admin1 = new Role("ROLE_ADMIN");
        roleService.addRole(user1);
        roleService.addRole(admin1);

        List<Role> roleUser = new ArrayList<>();
        roleUser.add(user1);
        User user = new User("user", "user", "user", "user", roleUser);
        User admin = new User("admin", "admin", "admin", "admin", roleService.getRoles());

        usersService.saveUser(user);
        usersService.saveUser(admin);

    }

}
