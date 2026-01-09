package com.project.hospitalManagement.service.impl;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import com.project.hospitalManagement.entity.Doctor;
import com.project.hospitalManagement.entity.Patient;
import com.project.hospitalManagement.repository.DoctorRepository;
import com.project.hospitalManagement.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DoctorDTO> getAllPatient() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> new DoctorDTO(doctor.getId(),doctor.getName(),doctor.getEmail(),doctor.getSpecialization())).toList();
    }

    @Override
    public DoctorDTO createNewDoctor(AddDoctorDTO addDoctorDTO) {
        Doctor doctor = modelMapper.map(addDoctorDTO, Doctor.class);
        Doctor newDoctor = doctorRepository.save(doctor);

        return modelMapper.map(newDoctor, DoctorDTO.class);
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Doctor not found with the id "+id));
        return  modelMapper.map(doctor,DoctorDTO.class);
    }

    @Override
    public void removeDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO updateDoctorById(DoctorDTO doctorDTO, Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Doctor is not found with the Id :-  " + id));
        doctor.setId(id);
        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor, DoctorDTO.class);
    }

    @Override
    public DoctorDTO updatePartialDoctor(Long id, Map<String, Object> updates) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Doctor is not found with this Id :- " + id));
        updates.forEach((field,value)-> {
            switch(field){
                case "name" :
                    doctor.setName((String)value);
                                break;
                case "email":
                    doctor.setEmail((String) value);
                                break;
                case "specialization" :
                    doctor.setSpecialization((String) value);
                                break;
                default:
                    throw new IllegalArgumentException("Invalid Field");
            }
        });
            Doctor updatedDoctor = doctorRepository.save((doctor));
            return modelMapper.map(updatedDoctor,DoctorDTO.class);
    }

}
