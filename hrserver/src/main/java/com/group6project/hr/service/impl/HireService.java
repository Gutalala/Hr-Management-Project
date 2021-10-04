package com.group6project.hr.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.group6project.hr.dao.HireDao;
import com.group6project.hr.dao.TokenDao;
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.ApplicationResult1;
import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.RegistrationToken6;
 
 

@Component
@Slf4j
public class HireService {
	
	TokenDao tokenDao;
	HireDao hireDao;
	
	HireService(TokenDao tokenDao, HireDao hireDao){
		
		this.tokenDao = tokenDao;
		this.hireDao = hireDao;
		
	}

	public TokenDao getTokenDao() {
		return tokenDao;
	}
	
	@Transactional
    public void saveToken(RegistrationToken6 token)  {
        
        System.out.println("tokenDao is null or not :" + tokenDao);
        tokenDao.saveToken(token);
       
    }
	
	@Transactional
    public List<RegistrationToken6> getToken(String token)  {
        
	     System.out.println("tokenDao is null or not :" + tokenDao);
           return tokenDao.getToken6(token);
       
    }
	
	@Transactional
    public List<ApplicationResult1> getApplications()  {
        
	   
           return hireDao.getApplications();
       
    }

	@Transactional
    public List<Employee6> getEmployeesById(int id)  {
        
	       log.info("GetEmployeeNonAsync");
           return hireDao.getEmployees(id);
       
    }

	@Transactional
    public List<Address6> getAddressesById(int id)  {

	       log.info("GetAddressNonAsync");
           return hireDao.getAddressById(id);
       
    }

	@Transactional
    public List<Contact6> getRefById(int id)  {

        log.info("GetRefNonAsync");
           return hireDao.getRefById(id);
       
    }

	@Transactional
    public List<Contact6> getEmergencyById(int id)  {

        log.info("GetEmergencyNonAsync");
           return hireDao.getEmergencyById(id);
       
    }
	
	@Transactional
    public void approveApplication(Integer employeeid, String comments)  {
        
	   
          hireDao.approveApplication(employeeid, comments);
          
          return;
       
    }
	
	@Transactional
    public void rejectApplication(Integer employeeId, String comments)  {
        
	   
          hireDao.rejectApplication(employeeId, comments);;
          
          return;
       
    }
	
	
	
	@Transactional
    public void addDocumentComment(Integer id, String comment)  {
        
	   
          hireDao.addDocumentComment(id, comment);
          
          return;
       
    }
	
	@Transactional
    public PersonalDocument6 getPersonalDocumentByIdAndTitle(Integer eid  )  {
        
	   
		return hireDao.getPersonalDocumentByIdAndTitle(eid );
          
     
       
    }
	
	@Transactional
    public void approveDocument(Integer fileid ) {
        
	   
			hireDao.approveDocument(fileid);;
          
     
       
    }
	
	@Transactional
    public void rejectedDocument(Integer fileid ) {
        
	   
			hireDao.rejectedDocument(fileid);;
          
     
       
    }
	

}
