package com.project.hospitalManagement.service;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DoctorService {
    List<DoctorDTO> getAllPatient();

    DoctorDTO createNewDoctor(AddDoctorDTO addDoctorDTO);

    Optional<DoctorDTO> getDoctorById(Long id);

    void removeDoctorById(Long id);

    DoctorDTO updateDoctorById(DoctorDTO doctorDTO, Long id);

    DoctorDTO updatePartialDoctor(Long id, Map<String, Object> updates);
}
