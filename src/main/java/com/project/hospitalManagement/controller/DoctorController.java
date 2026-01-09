package com.project.hospitalManagement.controller;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import com.project.hospitalManagement.service.DoctorService;
import com.project.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("{id}")
    public void deleteDoctorById(@PathVariable Long id){
        doctorService.removeDoctorById(id);
    }

    @PutMapping("{id}")
    public DoctorDTO updatedDoctorById(@RequestBody DoctorDTO doctorDTO,@PathVariable Long id){
        return doctorService.updateDoctorById(doctorDTO,id);
    }

    @PatchMapping("{id}")
    public DoctorDTO updatePartialDoctor(@PathVariable Long id, @RequestBody Map<String,Object> updates){
            return doctorService.updatePartialDoctor(id,updates);
    }

}
