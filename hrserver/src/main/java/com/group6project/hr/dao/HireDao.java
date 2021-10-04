package com.group6project.hr.dao;

import java.util.List;

 
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.ApplicationResult1;
import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.ResultPersonalDocumentEmployee;

public interface HireDao {
	
	
	
	List<ApplicationResult1> getApplications();
	
	List<Employee6> getEmployees(int id);

	List<Address6> getAddressById(int id);

	List<Contact6> getRefById(int id);

	List<Contact6> getEmergencyById(int id);
	
	 
	
 

	void approveApplication(Integer employeeId, String comments);
	
	void rejectApplication(Integer employeeId, String comments);
	
	void addDocumentComment(Integer id, String comment);

	List<ResultPersonalDocumentEmployee> getEnhancedPersonalDocuments();

	PersonalDocument6 getPersonalDocumentByIdAndTitle(Integer eid );

	void approveDocument(Integer fileid);

	void rejectedDocument(Integer fileid);

}
