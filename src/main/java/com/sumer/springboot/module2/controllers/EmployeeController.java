package com.sumer.springboot.module2.controllers;


import com.sumer.springboot.module2.dto.EmployeeDTO;
import com.sumer.springboot.module2.entities.EmployeeEntity;

import com.sumer.springboot.module2.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO=employeeService.getEmployeeById(id);
//        if(employeeDTO==null)return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
       return employeeDTO
               .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
               .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping(path="/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam (required = false) Integer age){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

//    @PostMapping(path="/")
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping(path="/")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

        EmployeeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping (path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
    }

    @DeleteMapping (path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean gotDeleted= employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping (path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object>updates
                                                , @PathVariable Long employeeId){
        EmployeeDTO employeeDTO=employeeService.updatePartialEmployeeById(employeeId,updates);
        if (employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

}
