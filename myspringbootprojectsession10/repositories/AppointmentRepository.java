package com.example.myspringbootprojectsession10.repositories;

import com.example.myspringbootprojectsession10.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDoctorId(Long doctorId);
}
