package com.group6project.hr.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.group6project.hr.dao.HireDao;
import com.group6project.hr.dao.VisaManagementDao;
import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.RegistrationToken6;
import com.group6project.hr.domains.ResultPersonalDocumentEmployee;
import com.group6project.hr.domains.VisaStatus6;

@Component
@Slf4j
public class VisaService {
	
	VisaManagementDao visaManagementDao;
	HireDao hireDao;
	
	VisaService(VisaManagementDao visaManagementDao, HireDao hireDao){
		
		this.visaManagementDao = visaManagementDao;
		this.hireDao = hireDao;
		
	}

	public VisaManagementDao getVisaManagementDao() {
		return visaManagementDao;
	}
	
	
	@Transactional
    public int getEmployeeId(int id)  {
        
	    
           return visaManagementDao.getEmployeeId(id);
       
    }

	@Transactional
    public VisaStatus6 getVisaStatus(int eid)  {
        
		   log.info("GetVisaNonAsync");
           return visaManagementDao.getVisaStatus(eid);
       
    }
	
	
	@Transactional
    public ApplicationWorkFlow6 getOptStatus(Integer employeeid )  {
   
		return visaManagementDao.getOptStatus(employeeid);
  
    }
	
	@Transactional
    public void changeOptStatus(Integer employeeid, String optStatus )  {
   
		 visaManagementDao.changeOptStatus(employeeid, optStatus);;
		 
		 return;
  
    }
	
	@Transactional
    public List<ApplicationWorkFlow6> getAllAWFWhichNeedsNotification()  {
   
		 return visaManagementDao.getAllAWFWhichNeedsNotification();
		 
	 
    }
	
	@Transactional
    public List<PersonalDocument6> getAllPersonalDocuments(Integer eid) {
   
		 return visaManagementDao.getAllPersonalDocuments(eid);
		 
	 
    }
	
	@Transactional
    public List<PersonalDocument6> getAllDocuments() {
   
		 return visaManagementDao.getAllDocuments();
		 
	 
    }
	
	@Transactional
    public List<ResultPersonalDocumentEmployee> getAllEnhancedPersonalDocuments() {
   
		 return hireDao.getEnhancedPersonalDocuments();
		 
	 
    }
	
	@Transactional
    public PersonalDocument6 getSinglePersonalDocument(Integer did) {
   
		 return visaManagementDao.getSinglePersonalDocument(did);
		 
	 
    }
	
	@Transactional
    public PersonalDocument6 geti983ByEmployeeid(Integer eid) {
   
		 return visaManagementDao.geti983ByEmployeeid(eid);
		 
	 
    }
	
	
	@Transactional
    public  List<ApplicationWorkFlow6>  getAllAWFWhichNeedsNotificationFile() {
   
		 return visaManagementDao.getAllAWFWhichNeedsNotificationFile();
		 
	 
    }
	

}
