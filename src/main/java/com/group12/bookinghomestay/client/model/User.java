package com.group12.bookinghomestay.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    private int role;
    private String token;
    private String providerKey;
    private String providerType;
}
