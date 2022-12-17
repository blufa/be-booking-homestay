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
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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
    @JsonManagedReference
    private Collection<Review> reviews;


}
