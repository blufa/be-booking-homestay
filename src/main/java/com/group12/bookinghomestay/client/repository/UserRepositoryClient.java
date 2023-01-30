package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryClient extends JpaRepository<User, String> {
    @Query(value = "select * from user where email = ?1 or username = ?2 limit 1", nativeQuery = true)
    User findExistedUser(String email, String username);

    @Query(value = "from User where email = ?1 and token = ?2")
    User findUserByEmail(String email,String token);
}
