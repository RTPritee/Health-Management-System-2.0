package com.java.system.service;

import com.java.system.model.DoctorModel;
import com.java.system.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctor(){
        return doctorRepository.findAll();
    }
    public Optional<DoctorModel> getDoctorById(Long id){
        return doctorRepository.findById(id);
    }
    public DoctorModel addDoctor(DoctorModel  doctorModel){
        return doctorRepository.save(doctorModel);
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }
    public DoctorModel updateDoctor(Long id, DoctorModel doctorDetails){
        return doctorRepository.findById(id).map(
                doctorModel -> {
                   doctorModel.setD_name(doctorDetails.getD_name());
                   doctorModel.setD_dept(doctorDetails.getD_dept());
                   return doctorRepository.save(doctorModel);
                }
        ).orElseThrow(()-> new RuntimeException("Doctor update failed"));
    }

}
