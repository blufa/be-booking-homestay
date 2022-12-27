package com.group12.bookinghomestay.admin.model;

import com.group12.bookinghomestay.admin.model.enums.Role;
import com.group12.bookinghomestay.admin.model.enums.Status;
import com.group12.bookinghomestay.admin.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    private String token;
    private String providerKey;
    private String providerType;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus active = UserStatus.UNACTIVATED;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Review> reviews;
}
