package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) { //, @RequestParam(defaultValue = "5", name = "count") int count) {
        List<User> usersResponse = new ArrayList<>(userService.listUsers());
        model.addAttribute("users" , usersResponse);
        return "users";
    }

    @GetMapping(value = "/admin/create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        List<Role> rolesResponse = new ArrayList<>(roleService.listRoles());
        model.addAttribute("roles", rolesResponse);
        return "create";
    }

    @PostMapping(value = "/admin")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.remove(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/edit")
    public String editUser(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping(value = "/admin/users")
    public String applyEditUser(Principal principal, @ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        user.setId(id);
        user.setPassword(userService.findByUsername(principal.getName()).getPassword());
        userService.edit(user);
        return "redirect:/admin";
    }
}
