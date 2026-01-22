package com.project.hospitalManagement.controller;

import com.project.hospitalManagement.dto.AddDoctorDTO;
import com.project.hospitalManagement.dto.DoctorDTO;
import com.project.hospitalManagement.exceptions.ResourceNotFoundException;
import com.project.hospitalManagement.service.DoctorService;
import com.project.hospitalManagement.service.PatientService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public ResponseEntity<DoctorDTO> findDoctorById(@PathVariable Long id){
        Optional<DoctorDTO> doctorDTO = doctorService.getDoctorById(id);

        return doctorDTO.map(doctorDTO1 -> ResponseEntity.ok(doctorDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Resource is not found with the Id " + id));
    }

    @DeleteMapping("{id}")
    public void deleteDoctorById(@PathVariable Long id){
        doctorService.removeDoctorById(id);
    }

    @PutMapping("{id}")
    public DoctorDTO updatedDoctorById(@RequestBody @Valid DoctorDTO doctorDTO, @PathVariable Long id){
        return doctorService.updateDoctorById(doctorDTO,id);
    }

    @PatchMapping("{id}")
    public DoctorDTO updatePartialDoctor(@PathVariable Long id, @RequestBody Map<String,Object> updates){
            return doctorService.updatePartialDoctor(id,updates);
    }


//    // Exception Handler
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleDoctorNotFoundException(NoSuchElementException exception){
//
//        return new ResponseEntity<>("Doctor Not found " , HttpStatus.NOT_FOUND);
//    }
}
