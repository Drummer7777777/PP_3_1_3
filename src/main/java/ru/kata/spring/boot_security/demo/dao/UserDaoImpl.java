package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    public User findByUsername(String username) {
        try {
            User user = entityManager.createQuery(
                            "SELECT u from User u WHERE u.username = :username", User.class).
                    setParameter("username", username).getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
