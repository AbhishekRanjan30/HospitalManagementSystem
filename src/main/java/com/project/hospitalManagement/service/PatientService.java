package com.project.hospitalManagement.service;

import com.project.hospitalManagement.entity.Patient;
import com.project.hospitalManagement.repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient getPatientById(Long id){

        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 =  patientRepository.findById(id).orElseThrow();

        return p1;
    }
}
