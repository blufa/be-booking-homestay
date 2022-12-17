package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    public List<Voucher> findAll(){
        return voucherRepository.findAll();
    }
}
