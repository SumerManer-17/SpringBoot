package com.sumer.springboot.module2.controllers;

import com.sumer.springboot.module2.dto.EmployeeDTO;
import com.sumer.springboot.module2.entities.EmployeeEntity;
import com.sumer.springboot.module2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping("/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret key: 2dsihi#hh";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Sumer","sumer@y.y",21,LocalDate.of(2026,3,2),true);
//    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping(path="/")
    public List<EmployeeEntity> getAllEmployees(@RequestParam (required = false) Integer age){
        return employeeRepository.findAll();
    }

//    @PostMapping(path="/")
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping(path="/")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){

        return employeeRepository.save(inputEmployee);
    }
}
