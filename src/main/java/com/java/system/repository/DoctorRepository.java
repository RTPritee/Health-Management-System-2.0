package com.java.system.repository;

import com.java.system.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorModel,Long > {
}
