package com.group6project.hr.dao;

import java.util.List;

import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.VisaStatus6;

public interface VisaManagementDao {
	
	
	int getEmployeeId(int userId);
	
	VisaStatus6 getVisaStatus(int empId);
	
	 ApplicationWorkFlow6  getOptStatus(Integer employeeId);
	 
	 void changeOptStatus(Integer empid, String optstatus);

	List<ApplicationWorkFlow6> getAllAWFWhichNeedsNotification();
	
	List<PersonalDocument6> getAllPersonalDocuments(Integer eid);

	List<PersonalDocument6> getAllDocuments();

	PersonalDocument6 getSinglePersonalDocument(Integer did);

	List<ApplicationWorkFlow6> getAllAWFWhichNeedsNotificationFile();

 

	PersonalDocument6 geti983ByEmployeeid(Integer eid);

}
