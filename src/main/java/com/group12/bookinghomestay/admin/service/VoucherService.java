package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    public List<Voucher> findAll(){
        return voucherRepository.findAll();
    }
    public Voucher save(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    public Optional<Voucher> findById(String id) {
        return voucherRepository.findById(id);
    }
}
