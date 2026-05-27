package com.example.hospitalManagementSystem.Service;

import com.example.hospitalManagementSystem.repository.InsuranceRepository;
import com.example.hospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;


}
