package com.group6project.hr.dao;

import com.group6project.hr.domains.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployeeByUserId(Integer user_id);
    List<Employee> getEmployeeList();
    void updateEmployee(Employee employee);
}
