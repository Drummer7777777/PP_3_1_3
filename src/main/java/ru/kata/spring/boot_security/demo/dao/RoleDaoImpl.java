package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public Role getByName(String name) {
        try {
            Role role = entityManager.createQuery(
                            "SELECT r from Role r WHERE r.name = :name", Role.class).
                    setParameter("name", name).getSingleResult();
            return role;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }
}
