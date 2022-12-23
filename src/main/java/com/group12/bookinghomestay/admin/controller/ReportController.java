package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.model.Voucher;
import com.group12.bookinghomestay.admin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    private static final String PATH = "/reports";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Report> getReportList() {
        return reportService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}")
    public Report getReportById(@PathVariable(name = "id") Long id) {
        return reportService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = PATH + "/{id}", consumes = {"application/json"})
    public Report replaceReport(@RequestBody Report newReport, @PathVariable("id") Long id) {
        return reportService.findById(id).map(report -> {
            report.setStatus(newReport.getStatus());
            return reportService.save(report);
        }).orElseGet(() -> {
            newReport.setId(id);
            return reportService.save(newReport);
        });
    }

    @CrossOrigin("*")
    @PostMapping(PATH + "/add")
    public Report addReport(@RequestBody Report report) {
        return reportService.save(report);
    }
}
