package com.project.hospitalManagement.service.impl;

import com.project.hospitalManagement.dto.AddPatientDto;
import com.project.hospitalManagement.dto.PatientDto;
import com.project.hospitalManagement.entity.Patient;
import com.project.hospitalManagement.repository.PatientRepository;
import com.project.hospitalManagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatienServiceImpl implements PatientService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PatientRepository patientRepository;


    @Override
    public PatientDto createNewPatient(AddPatientDto addPatientDto) {
        Patient newPatient = modelMapper.map(addPatientDto, Patient.class);
        Patient patient = patientRepository.save(newPatient);
        return modelMapper.map(patient, PatientDto.class);
    }


    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(patient -> new PatientDto(patient.getId(),patient.getName(),patient.getEmail(),patient.getGender(),patient.getBirthDate(),patient.getBloodGroup())).toList();
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException("patient is not found" + id));
        return modelMapper.map(patient,PatientDto.class);
    }
}
