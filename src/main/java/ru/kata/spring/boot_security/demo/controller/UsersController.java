package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Model.Role;
import ru.kata.spring.boot_security.demo.Model.User;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UsersService;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping()
public class UsersController {

    private final UsersService usersService;


    @Autowired
    public UsersController(UsersService usersService, RoleService roleService) {

        this.usersService = usersService;

    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {

        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user) {
        Role role = new Role("ROLE_USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        usersService.saveUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", usersService.getUserByUsername(principal.getName()));
        User user = usersService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "/user";
    }

}
