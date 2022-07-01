package br.senai.service;

import br.senai.model.Bar;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class CustomUser extends User {

    private final List<Bar> inventory;

    private final String email;

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked, Collection<?
                      extends GrantedAuthority> authorities, List<Bar> inventory, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.inventory = inventory;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}