package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoucherController {
    private static final String PATH="/vouchers";
    @Autowired
    private VoucherService voucherService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Voucher> getRoomList() {
        return voucherService.findAll();
    }
}
