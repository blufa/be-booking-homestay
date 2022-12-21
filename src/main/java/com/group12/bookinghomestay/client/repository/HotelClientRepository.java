package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelClientRepository extends JpaRepository<Hotel,Long> {
    @Query("SELECT h FROM Hotel h WHERE h.name = ?1")
    public Hotel getHotelByName(String name);
}
