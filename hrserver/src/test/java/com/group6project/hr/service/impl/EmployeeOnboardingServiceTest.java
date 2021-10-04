package com.group6project.hr.service.impl;

import com.group6project.hr.dao.impl.EmployeeDaoImpl;
import com.group6project.hr.domains.Contact;
import com.group6project.hr.domains.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeOnboardingServiceTest {

//    @InjectMocks
//    static EmployeeOnboardingService employeeOnboardingService;
//    @Mock
//    static EmployeeDaoImpl employeeDao;
//
//
//    @Test
//    public void addEmployee() {
//        Employee employee = setupEmployee(1, "John");
//        when(employeeOnboardingService.addEmployee(employee)).thenReturn(employee);
//        verify(employeeDao, times(1)). addEmployee(any());
//    }
//
//    static Employee setupEmployee(int id, String firstName){
//        Employee employee = new Employee();
//        Contact contact1 = new Contact();
//        contact1.setId(1);
//        Contact contact2 = new Contact();
//        contact2.setId(2);
//        List<Contact> contactList = new ArrayList<>();
//        contactList.add(contact1);
//        contactList.add(contact2);
//        employee.setContact(contactList);
//        employee.setId(id);
//        employee.setFirstName(firstName);
//
//        return employee;
//    }

}