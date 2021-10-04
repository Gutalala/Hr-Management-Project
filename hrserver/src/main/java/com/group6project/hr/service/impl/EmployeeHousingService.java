package com.group6project.hr.service.impl;

import com.group6project.hr.dao.impl.EmployeeDaoImpl;
import com.group6project.hr.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeHousingService {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    public void setEmployeeOnboardingDao(EmployeeDaoImpl employeeDaoImpl){this.employeeDaoImpl = employeeDaoImpl;}

    @Transactional
    public List<Employee> findEmployeeByHouse(int house_id){
        return this.employeeDaoImpl.findEmployeeByHouse(house_id);
    }

    @Transactional
    public Employee findEmployeeById(int employee_id){
        return this.employeeDaoImpl.findEmployeeById(employee_id);
    }

    @Transactional
    public String findEmployeeNameById(int employee_id){
        return this.employeeDaoImpl.findEmployeeNameById(employee_id);
    }

}