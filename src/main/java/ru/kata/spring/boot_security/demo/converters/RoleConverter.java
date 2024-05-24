package ru.kata.spring.boot_security.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.dao.RoleDao;

@Component
public class RoleConverter implements Converter<String, Role> {

    private final RoleDao roleDao;

    @Autowired
    public RoleConverter(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role convert(String name) {
        return roleDao.getByName(name);
    }
}
