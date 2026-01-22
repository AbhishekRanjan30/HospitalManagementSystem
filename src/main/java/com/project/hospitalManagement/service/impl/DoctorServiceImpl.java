package com.project.hospitalManagement.service.impl;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import com.project.hospitalManagement.entity.Doctor;
import com.project.hospitalManagement.exceptions.ResourceNotFoundException;
import com.project.hospitalManagement.repository.DoctorRepository;
import com.project.hospitalManagement.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DoctorDTO> getAllPatient() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getSpecialization())).toList();
    }

    @Override
    public DoctorDTO createNewDoctor(AddDoctorDTO addDoctorDTO) {
        Doctor doctor = modelMapper.map(addDoctorDTO, Doctor.class);
        Doctor newDoctor = doctorRepository.save(doctor);

        return modelMapper.map(newDoctor, DoctorDTO.class);
    }

    @Override
    public Optional<DoctorDTO> getDoctorById(Long id) {
        ifExistDoctor(id);
        return doctorRepository.findById(id).map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
    }

    @Override
    public void removeDoctorById(Long id) {
        ifExistDoctor(id);
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO updateDoctorById(DoctorDTO doctorDTO, Long id) {
        ifExistDoctor(id);
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        doctor.setId(id);
        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor, DoctorDTO.class);

    }

    @Override
    public DoctorDTO updatePartialDoctor(Long id, Map<String, Object> updates) {
        ifExistDoctor(id);
        Doctor doctor = doctorRepository.findById(id).get();
        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    doctor.setName((String) value);
                    break;
                case "email":
                    doctor.setEmail((String) value);
                    break;
                case "specialization":
                    doctor.setSpecialization((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Field");
            }
        });
        Doctor updatedDoctor = doctorRepository.save((doctor));
        return modelMapper.map(updatedDoctor, DoctorDTO.class);
    }

    public void ifExistDoctor(Long id) {
        boolean exists = doctorRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Resource not found with the id :- " + id);
    }
}
