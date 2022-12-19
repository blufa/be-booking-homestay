package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    public List<Report> getAll(){
        return reportRepository.findAll();
    }
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }
}
