package com.example.myspringbootprojectsession10.services;

import com.example.myspringbootprojectsession10.dto.DoctorRequest;
import com.example.myspringbootprojectsession10.entities.Doctor;
import com.example.myspringbootprojectsession10.exceptions.DoctorNotFoundException;
import com.example.myspringbootprojectsession10.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Doctor findById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
    }

    @Transactional
    public Doctor create(DoctorRequest request) {
        return doctorRepository.save(new Doctor(
                request.getFullName(),
                request.getSpecialty(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @Transactional
    public Doctor update(Long id, DoctorRequest request) {
        Doctor doctor = findById(id);
        doctor.setFullName(request.getFullName());
        doctor.setSpecialty(request.getSpecialty());
        doctor.setEmail(request.getEmail());
        doctor.setPhone(request.getPhone());
        return doctorRepository.save(doctor);
    }

    @Transactional
    public void delete(Long id) {
        Doctor doctor = findById(id);
        doctorRepository.delete(doctor);
    }
}
