package com.group6.employeeonboarding.controllers;


import com.group6.employeeonboarding.domains.Employee;
import com.group6.employeeonboarding.service.EmployeeHousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    EmployeeHousingService employeeHousingService;

    @Autowired
    public void setEmployeeHousingService(EmployeeHousingService employeeHousingService){this.employeeHousingService = employeeHousingService;}

    @PostMapping("/api/employeeById")
    public ResponseEntity findEmployeeById(@RequestBody int id){
        String name = "";
        try {
            name = this.employeeHousingService.findEmployeeById(id).getFirstName();
            return new ResponseEntity<>(name, HttpStatus.ACCEPTED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(name, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
