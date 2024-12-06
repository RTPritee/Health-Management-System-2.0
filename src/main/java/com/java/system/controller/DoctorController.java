package com.java.system.controller;

import com.java.system.model.DoctorModel;
import com.java.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<DoctorModel> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorModel> getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id).map(
                ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public DoctorModel addDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.addDoctor(doctorModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorModel> updateDoctor(@PathVariable Long id, DoctorModel doctorDetails) {
        try {
            return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDetails));

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable  Long id){
        try {
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}
