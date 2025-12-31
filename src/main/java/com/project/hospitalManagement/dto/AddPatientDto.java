package com.project.hospitalManagement.dto;

import com.project.hospitalManagement.entity.type.BloodGroupType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AddPatientDto {

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    private BloodGroupType bloodGroup;
}
