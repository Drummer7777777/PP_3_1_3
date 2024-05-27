package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private int id;
    private String name;
    public Role() {}
    public Role(String name) {}
    public Role(int id) {
        this.id = id;
    }
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrimName() {   // удаляеи ROLE_ из роли
        return name.replace("ROLE_", "");
    }

    public Role getRole() {
        return this;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
