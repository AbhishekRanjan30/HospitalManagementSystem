package com.project.hospitalManagement.repository;

import com.project.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApppointmentRepository extends JpaRepository<Appointment, Long> {
}
