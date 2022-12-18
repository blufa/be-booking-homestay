package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.client.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryClient extends JpaRepository<UserClient,Integer> {
/*
    UserClient save(UserClient user);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public UserClient findByEmail(String email);

 */
}
