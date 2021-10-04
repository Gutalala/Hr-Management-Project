package com.group6project.hr.service.impl;

import com.group6project.hr.dao.impl.EmployeeDaoImpl;
import com.group6project.hr.domains.Employee;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeOnboardingService {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    public void setEmployeeDaoImpl(EmployeeDaoImpl employeeDaoImpl){this.employeeDaoImpl = employeeDaoImpl;}

    @Transactional
    @Generated
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
