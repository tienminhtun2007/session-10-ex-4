package com.example.myspringbootprojectsession10.repositories;

import com.example.myspringbootprojectsession10.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Optional<Prescription> findByIdAndPatientId(Long id, Long patientId);
}
