package com.java.system.service;

import com.java.system.model.Patient;
import com.java.system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getALLPatient(){
        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
    public Patient updatePatient(Long id , Patient patientDetails){
        return patientRepository.findById(id).map(
                patient -> {
                    patient.setP_name(patientDetails.getP_name());
                    patient.setP_age(patientDetails.getP_age());
                    patient.setP_gender(patientDetails.getP_gender());

                    return patientRepository.save(patient);
                }
        ).orElseThrow(()->new RuntimeException("Patient Not Found"));
    }
}
