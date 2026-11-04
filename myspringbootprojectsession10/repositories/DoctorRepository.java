package com.example.myspringbootprojectsession10.repositories;

import com.example.myspringbootprojectsession10.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
