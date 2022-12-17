package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {

}
