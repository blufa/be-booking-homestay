package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,String> {
}
