package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from Customer where email = :email or phone = :phone limit 1", nativeQuery = true)
    public Customer getCustomerExisted(@Param("email") String email, @Param("phone") String phone);
}
