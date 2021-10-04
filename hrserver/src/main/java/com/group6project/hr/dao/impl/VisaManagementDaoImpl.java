package com.group6project.hr.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.TokenDao;
import com.group6project.hr.dao.VisaManagementDao;
import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.RegistrationToken6;
import com.group6project.hr.domains.VisaStatus6;

@Repository 
public class VisaManagementDaoImpl extends AbstractHibernateDao<VisaStatus6> implements VisaManagementDao {

	@Override
	public int getEmployeeId(int userId) {
		
		Employee6 emp = null ;
		 
		String sql = "FROM Employee6 WHERE user_id = "+ userId ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	emp = (Employee6) query.list().get(0);
        } catch (NoResultException e) {
            System.out.println("Employee does not exist with user id");
        }
 
		return emp.getId();
	}

	@Override
	public VisaStatus6 getVisaStatus(int empId) {
		
		VisaStatus6 visaStatus = null;
		String sql = "FROM VisaStatus6 WHERE employee_id = "+ empId ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	visaStatus = (VisaStatus6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("visaStatus6 does not exist with employee id");
        }
		
		// TODO Auto-generated method stub
		return visaStatus;
	}
	
	@Override
	public  ApplicationWorkFlow6  getOptStatus(Integer employeeId) {
		ApplicationWorkFlow6  awf = null;
		String sql = "FROM ApplicationWorkFlow6 WHERE employee_id = "+ employeeId +" AND (status like '%OPT%' or status like '%I-983%' or status like '%I-20%') ";
		Query query =  getCurrentSession().createQuery(sql);
		List<ApplicationWorkFlow6> awfs = query.list();
		return awfs == null ? null : awfs.get(0);
 	
	}

	@Override
	public void changeOptStatus(Integer empid, String optstatus) {
		
		ApplicationWorkFlow6  awf = null;
		String sql = "FROM ApplicationWorkFlow6 WHERE employee_id = "+ empid +" AND (status like '%OPT%' or status like '%I-983%' or status like '%I-20%') ";
		Query query =  getCurrentSession().createQuery(sql);
		List<ApplicationWorkFlow6> awfs = query.list();
	     if (awfs != null) {
	    	 
	    	 awf = awfs.get(0);
	    	 awf.setStatus(optstatus);
	    	 
	    	 getCurrentSession().update(awf);
	    	 
	     }
		 
		
	}
	
	
	@Override
	public  List<ApplicationWorkFlow6>  getAllAWFWhichNeedsNotificationFile() {
 
		String sql = "FROM ApplicationWorkFlow6 WHERE status like '%pending%' or status like '%Waiting%' ";
		Query query =  getCurrentSession().createQuery(sql);
		return  query.list();
	 
 	
	}
	
	
	@Override
	public  List<ApplicationWorkFlow6>  getAllAWFWhichNeedsNotification() {
 
		String sql = "FROM ApplicationWorkFlow6 WHERE status like '%OPT%' or status like '%I-983%' or status like '%I-20%' ";
		Query query =  getCurrentSession().createQuery(sql);
		return  query.list();
	 
 	
	}

	@Override
	public List<PersonalDocument6> getAllPersonalDocuments(Integer eid) {
		
 
		Query query =  getCurrentSession().createQuery("FROM PersonalDocument6 WHERE employee_id = :eid ORDER BY createdDate desc");
		  query.setParameter("eid", eid);
		  
		  return query.list();
		
		 
	}
	
	@Override
	public PersonalDocument6 getSinglePersonalDocument(Integer did) {
		
 
		Query query =  getCurrentSession().createQuery("FROM PersonalDocument6 WHERE id = :did");
		  query.setParameter("did", did);
		  
		  return (PersonalDocument6) query.getSingleResult();
		
		 
	}
	
	@Override
	public PersonalDocument6 geti983ByEmployeeid(Integer eid) {
		
 
		Query query =  getCurrentSession().createQuery("FROM PersonalDocument6 WHERE employee_id = :eid AND title ='I-983 Waiting For Approval' ");
		  query.setParameter("eid", eid);
		  
		  return (PersonalDocument6) query.getSingleResult();
		
		 
	}
	
	
	@Override
	public List<PersonalDocument6> getAllDocuments() {
		
 
		Query query =  getCurrentSession().createQuery("FROM PersonalDocument6");

		  
		  return query.list();
		
		 
	}
	
	
	
	

}
