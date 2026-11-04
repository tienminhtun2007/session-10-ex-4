package com.example.myspringbootprojectsession10.repositories;

import com.example.myspringbootprojectsession10.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
