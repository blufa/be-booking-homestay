package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Facility;
import com.group12.bookinghomestay.admin.model.Facility;
import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    public List<Facility> getAll(){
        return facilityRepository.findAll();
    }
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    public Optional<Facility> findById(Long id) {
        return facilityRepository.findById(id);
    }

}
