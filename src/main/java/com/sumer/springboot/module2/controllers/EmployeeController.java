package com.sumer.springboot.module2.controllers;


import com.sumer.springboot.module2.dto.EmployeeDTO;
import com.sumer.springboot.module2.entities.EmployeeEntity;

import com.sumer.springboot.module2.services.EmployeeService;
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


    //    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Sumer","sumer@y.y",21,LocalDate.of(2026,3,2),true);
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path="/")
    public List<EmployeeDTO> getAllEmployees(@RequestParam (required = false) Integer age){
        return employeeService.getAllEmployees();
    }

//    @PostMapping(path="/")
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping(path="/")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

        return employeeService.createNewEmployee(inputEmployee);
    }
}
