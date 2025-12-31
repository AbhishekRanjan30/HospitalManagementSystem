package com.project.hospitalManagement.controller;

import com.project.hospitalManagement.dto.AddPatientDto;
import com.project.hospitalManagement.dto.PatientDto;
import com.project.hospitalManagement.entity.Patient;
import com.project.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

        @PostMapping("")
        public PatientDto createPatient(@RequestBody AddPatientDto addPatientDto){
            return patientService.createNewPatient(addPatientDto);
        }

        @GetMapping("")
        public List<PatientDto> getAllPatient(){
            return patientService.getAllPatient();
        }

        @GetMapping("{id}")
        public PatientDto getPatientById(@PathVariable Long id){
            return patientService.getPatientById(id);
        }

}
