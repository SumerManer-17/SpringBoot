package com.example.hospitalManagementSystem.repository;

import com.example.hospitalManagementSystem.dto.BloodGroupStats;
import com.example.hospitalManagementSystem.dto.CPatientInfo;
import com.example.hospitalManagementSystem.dto.IPatientInfo;
import com.example.hospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("select p.id, p.name, p.email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.example.hospitalManagementSystem.dto.CPatientInfo(p.id, p.name) "+"from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.example.hospitalManagementSystem.dto.BloodGroupStats (p.bloodGroup,"+"COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p)")
    List<BloodGroupStats>getBloodGroupStats();
}
