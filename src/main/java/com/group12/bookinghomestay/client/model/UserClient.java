package com.group12.bookinghomestay.client.model;

import javax.persistence.*;


@Entity
public class UserClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private int role;
    private String token;
    private String providerKey;
    private String providerType;
    private int active;

    public UserClient(){
    }

    public UserClient(String username, String password, String email, int role, String token, String providerKey, String providerType,  int active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
        this.providerKey = providerKey;
        this.providerType = providerType;
        this.active = active;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserClient{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", token='" + token + '\'' +
                ", providerKey='" + providerKey + '\'' +
                ", providerType='" + providerType + '\'' +
                ", id=" + id +
                ", active=" + active +
                '}';
    }
}
