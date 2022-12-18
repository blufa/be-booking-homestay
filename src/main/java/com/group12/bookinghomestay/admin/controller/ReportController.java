package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    private static final String PATH="/reports";
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Report> getReportList() {
        return reportService.getAll();
    }
}
