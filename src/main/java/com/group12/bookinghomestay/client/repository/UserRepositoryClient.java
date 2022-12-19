package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.client.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryClient extends JpaRepository<UserClient,Integer> {

    @Query("SELECT u FROM UserClient u WHERE u.email = ?1")
    public UserClient findByEmail(String email);

    @Query("SELECT u FROM UserClient u WHERE u.email = ?1")
    public List<UserClient> findAllByEmail(String email);

}
