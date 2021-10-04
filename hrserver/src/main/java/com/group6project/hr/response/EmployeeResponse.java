package com.group6project.hr.response;
 

 

import java.util.List;

import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private String visatype;
    private ResponseStatus status;
    private Employee6 employee;
    private Address6 address;
    private  Contact6 reference;
    private List<Contact6> contacts;
    
    
}
