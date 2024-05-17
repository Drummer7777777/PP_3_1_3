package ru.kata.spring.boot_security.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void add(User user);
    void remove(int id);
    void edit(User user);
    User getById(int id);
    User findByUsername(String username);
}
