package com.example.hospitalManagementSystem;

import com.example.hospitalManagementSystem.dto.BloodGroupStats;
import com.example.hospitalManagementSystem.dto.CPatientInfo;
import com.example.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient(){
//        List<IPatientInfo> patientList=patientRepository.getAllPatientsInfo();
//
//        for(IPatientInfo p:patientList){
//            System.out.println(p);
//        }

//        List<CPatientInfo>patientList=patientRepository.getAllPatientsInfoConcrete();
//        for (CPatientInfo p:patientList){
//            System.out.println(p);
//        }

        List<BloodGroupStats>bloodGroupStats=patientRepository.getBloodGroupStats();
        for (BloodGroupStats b:bloodGroupStats){
            System.out.println(b);
        }
    }
}
