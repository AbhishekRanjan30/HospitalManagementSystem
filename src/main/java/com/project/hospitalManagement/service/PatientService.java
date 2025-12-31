package com.project.hospitalManagement.service;

import com.project.hospitalManagement.dto.AddPatientDto;
import com.project.hospitalManagement.dto.PatientDto;
import com.project.hospitalManagement.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDto> getAllPatient();

    PatientDto createNewPatient(AddPatientDto addPatientDto);

    PatientDto getPatientById(Long id);


//    @Autowired
//    PatientRepository patientRepository;
//
//    public Patient getPatientById(Long id){
//
//        Patient p1 = patientRepository.findById(id).orElseThrow();
//
//        Patient p2 =  patientRepository.findById(id).orElseThrow();
//
//        return p1;
//    } // This was the class where I have tested the code from junit coding

}
