package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    @Qualifier("roleDaoImpl")
    private RoleDao roleDao;

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
