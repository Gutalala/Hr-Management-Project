package com.group6project.hr.controllers;

import com.group6project.hr.domains.Employee;
import com.group6project.hr.service.impl.EmployeeHousingService;
import com.group6project.hr.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private EmployeeService employeeService;

    EmployeeHousingService employeeHousingService;

    @Autowired
    public void setEmployeeHousingService(EmployeeHousingService employeeHousingService){this.employeeHousingService = employeeHousingService;}

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) { this.employeeService = employeeService; }

    @PostMapping("/getEmployee")
    public Employee doPostGetEmployeeByUserId(@RequestBody int user_id){
        return employeeService.getEmployeeByUserId(user_id);
    }

    @GetMapping(path = "/getEmployeeList")
    public List<Employee> doGetEmployeeList(){
        return employeeService.getEmployeeList();
    }


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
