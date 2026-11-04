package com.example.myspringbootprojectsession10.dto;

public class PrescriptionRequest {

    private String medicine;
    private String dosage;

    public PrescriptionRequest() {
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
