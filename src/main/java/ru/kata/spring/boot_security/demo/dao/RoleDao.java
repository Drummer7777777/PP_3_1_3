package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public Role getByName(String name) {
        Role role = entityManager.find(Role.class, name);
        return role;
    }
}
