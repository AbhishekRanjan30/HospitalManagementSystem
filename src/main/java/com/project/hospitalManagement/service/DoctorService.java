package com.project.hospitalManagement.service;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import java.util.List;

public interface DoctorService {
    List<DoctorDTO> getAllPatient();

    DoctorDTO createNewDoctor(AddDoctorDTO addDoctorDTO);

    DoctorDTO getDoctorById(Long id);
}
