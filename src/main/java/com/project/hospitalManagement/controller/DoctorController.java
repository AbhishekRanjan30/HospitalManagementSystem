package com.project.hospitalManagement.controller;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import com.project.hospitalManagement.service.DoctorService;
import com.project.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllPatient();

    }
    @PostMapping("")
    public DoctorDTO createNewDoctor(@RequestBody AddDoctorDTO addDoctorDTO){
        return doctorService.createNewDoctor(addDoctorDTO);
    }

    @GetMapping("{id}")
    public DoctorDTO findDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }
}
