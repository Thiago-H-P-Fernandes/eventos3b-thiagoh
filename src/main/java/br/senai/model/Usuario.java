package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "password")
    private String password;

    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> permissions;

    @ManyToMany
    @JoinTable(
            name = "inventory",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bebida_id")
    )
    private List<Bar> inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String user_password) {
        this.password = user_password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Role> permissions) {
        this.permissions = permissions;
    }

    public List<Bar> getInventory() {
        return inventory;
    }
    public void setInventory(List<Bar> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Usuário:" +
                "\nID: " + id +
                "\nUsername: " + username + '\'' +
                "\nPassword: " + password + '\'' +
                "\nEmail: " + email ;
    }
}
