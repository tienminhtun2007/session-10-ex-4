package com.example.myspringbootprojectsession10.controllers;

import com.example.myspringbootprojectsession10.dto.PrescriptionRequest;
import com.example.myspringbootprojectsession10.entities.Patient;
import com.example.myspringbootprojectsession10.entities.Prescription;
import com.example.myspringbootprojectsession10.repositories.PatientRepository;
import com.example.myspringbootprojectsession10.repositories.PrescriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients/{patientId}/prescriptions")
public class PrescriptionController {

    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionController(PatientRepository patientRepository,
                                  PrescriptionRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> findByPatient(
            @PathVariable Long patientId,
            @PathVariable Long prescriptionId) {
        return prescriptionRepository.findByIdAndPatientId(prescriptionId, patientId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prescription> create(
            @PathVariable Long patientId,
            @RequestBody PrescriptionRequest request) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        Prescription prescription = new Prescription(
                request.getMedicine(), request.getDosage(), patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(prescriptionRepository.save(prescription));
    }
}
