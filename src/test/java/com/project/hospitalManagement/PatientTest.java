package com.project.hospitalManagement;

import com.project.hospitalManagement.entity.Patient;
import com.project.hospitalManagement.entity.type.BloodGroupType;
import com.project.hospitalManagement.repository.PatientRepository;
import com.project.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionalMethods(){
//
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);

     //   Patient patient1 = patientRepository.findByName("Abhishek Ranjan");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1998,04,9),"vishwas@gmail.com");
//        for(Patient patient : patientList){
////            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }
//
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1996,04,9));
//        for(Patient patient : patientList){
//            System.out.println((patient));
//        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects : bloodGroupList){
//            System.out.println(objects[0] + "  " + objects[1]);
//        }

//        List<Patient> patientList = patientRepository.findAllPatient();
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }

        int rowsUpdated = patientRepository.updateNameWithId("Abhishek", 1L);
        System.out.println(rowsUpdated);
    }
}
