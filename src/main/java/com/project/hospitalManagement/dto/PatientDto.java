package com.project.hospitalManagement.dto;

import com.project.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    private BloodGroupType bloodGroup;

    public PatientDto(Long id, String name, String email, String gender, LocalDate birthDate, BloodGroupType bloodGroup) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
    }
}
