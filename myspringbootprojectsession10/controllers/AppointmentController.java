package com.example.myspringbootprojectsession10.controllers;

import com.example.myspringbootprojectsession10.entities.Appointment;
import com.example.myspringbootprojectsession10.repositories.AppointmentRepository;
import com.example.myspringbootprojectsession10.repositories.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors/{doctorId}/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentController(AppointmentRepository appointmentRepository,
                                 DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> findByDoctor(@PathVariable Long doctorId) {
        if (!doctorRepository.existsById(doctorId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointmentRepository.findAllByDoctorId(doctorId));
    }
}
