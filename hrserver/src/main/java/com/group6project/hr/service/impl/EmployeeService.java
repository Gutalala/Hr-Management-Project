package com.group6project.hr.service.impl;

import com.group6project.hr.dao.EmployeeDao;
import com.group6project.hr.dao.impl.EmployeeDaoImpl;
import com.group6project.hr.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {this.employeeDao = employeeDao;}

    @Transactional
    public List<Employee> getEmployeeList(){ return employeeDao.getEmployeeList(); }

    @Transactional
    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public Employee getEmployeeByUserId(int user_id) { return employeeDao.getEmployeeByUserId(user_id); }
}
