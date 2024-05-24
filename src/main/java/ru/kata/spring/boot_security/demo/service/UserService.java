package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<User> listUsers();
    boolean add(User user);
    void remove(int id);
    void edit(User user);
    User getById(int id);
    User findByUsername(String username);
}
