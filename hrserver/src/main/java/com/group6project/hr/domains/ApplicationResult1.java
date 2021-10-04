package com.group6project.hr.domains;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ApplicationResult1 implements Serializable{
	
	@ApiModelProperty(position = 1)
	private int employeeId;

	@ApiModelProperty(position = 2)
	private String status, firstName, lastName, email;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ApplicationResult1(int employeeId, String email, String firstName, String lastName,String status ) {
		super();
		this.employeeId = employeeId;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	

}
