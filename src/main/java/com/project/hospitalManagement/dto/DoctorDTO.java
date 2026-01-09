package com.project.hospitalManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Size( min = 3 , max = 15 , message = "Name can be between 3 to 15 characters only")
    private String name;

    @NotNull
    private String specialization;

    @Email(message = "Email should be Valid Email")
    @NotBlank
    private String email;

    public DoctorDTO(Long id, String name, String email, String specialization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
    }
}
