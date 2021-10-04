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
public class EmployeeFullVisaInfo {
	
	private Integer employeeId;
	
	private String email;
	private String firstname, lastname, visaType,startDate,endDate, actionRequired, visaStatus;
	
	
	private Integer dayLeft;
	
	public List<VisaDocument> visaDocuments;
	
	
	

}


//public employeeId:Number;
//public firstname : String;
//public lastname:String;
//public visaType:String;
//public startDate: String;
//public endDate:String;
//public dayLeft:Number;
//public actionRequired:String;
//
//public visaStatus:String;
//
//public visaDocuments: VisaDocument[];