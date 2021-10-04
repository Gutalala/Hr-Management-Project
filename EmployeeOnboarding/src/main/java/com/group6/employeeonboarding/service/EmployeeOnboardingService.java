package com.group6.employeeonboarding.service;

import com.group6.employeeonboarding.dao.impl.EmployeeDaoImpl;
import com.group6.employeeonboarding.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeOnboardingService {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    public void setEmployeeOnboardingDao(EmployeeDaoImpl employeeDaoImpl){this.employeeDaoImpl = employeeDaoImpl;}

    @Transactional
    public Employee addEmployee(Employee employee) {
        employee.getContact().forEach(contact -> {
            contact.setEmployee(employee);
            this.employeeDaoImpl.addContact(contact);
        });

        employee.getAddress().setEmployee(employee);
        employee.getVisaStatus().setEmployee(employee);
        this.employeeDaoImpl.addEmployee(employee);

        return employee;

    }

}
