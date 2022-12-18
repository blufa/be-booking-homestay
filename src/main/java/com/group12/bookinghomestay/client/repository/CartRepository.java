package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.client.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from Cart where session_id = ?1", nativeQuery = true)
    List<Cart> findAllBySessionId(String id);

    @Query(value = "select * from Cart where session_id = ?1 and hotel_id = ?2", nativeQuery = true)
    Cart findCartItemByHotelId(String id, int hotelId);
}