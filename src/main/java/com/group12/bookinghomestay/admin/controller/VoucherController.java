package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoucherController {
    private static final String PATH = "/vouchers";
    @Autowired
    private VoucherService voucherService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Voucher> getRoomList() {
        return voucherService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}")
    public Voucher getVoucherById(@PathVariable(name = "id") String id) {
        return voucherService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = PATH + "/{id}", consumes = {"application/json"})
    public Voucher replaceVoucher(@RequestBody Voucher newVoucher, @PathVariable("id") String id) {
        return voucherService.findById(id).map(voucher -> {
            voucher.setDescription(newVoucher.getDescription());
            voucher.setExpiredDate(newVoucher.getExpiredDate());
            voucher.setRate(newVoucher.getRate());
            voucher.setMinimumSpending(newVoucher.getMinimumSpending());
            voucher.setStatus(newVoucher.getStatus());
            return voucherService.save(voucher);
        }).orElseGet(() -> {
            newVoucher.setId(id);
            return voucherService.save(newVoucher);
        });
    }
}
