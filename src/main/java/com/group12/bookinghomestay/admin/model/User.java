package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group12.bookinghomestay.admin.model.enums.Role;
import com.group12.bookinghomestay.admin.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String token;
    private String providerKey;
    private String providerType;
    private Status active;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Review> reviews;

    public User(String username, String password, String email, Role role, String token, String providerKey, String providerType, Status active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
        this.providerKey = providerKey;
        this.providerType = providerType;
        this.active = active;
    }
    public User(){
    }
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public Status getActive() {
        return active;
    }

    public void setActive(Status active) {
        this.active = active;
    }
}
