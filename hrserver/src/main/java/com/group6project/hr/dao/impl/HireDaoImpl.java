package com.group6project.hr.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.HireDao;
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.ApplicationResult1;
import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.RegistrationToken6;
import com.group6project.hr.domains.ResultPersonalDocumentEmployee;
import com.group6project.hr.domains.VisaStatus6;
 
 
@Repository 
public class HireDaoImpl extends AbstractHibernateDao<ApplicationResult1> implements HireDao{

	@Override
	public List<ApplicationResult1> getApplications() {
		
			
		  Query<ApplicationResult1> query2 = getCurrentSession().createQuery(
					"select new com.group6project.hr.domains.ApplicationResult1(awf.employee_id, e.email, e.firstName, e.lastName, awf.status) "
				  
					+ "FROM ApplicationWorkFlow awf, Employee6 e WHERE awf.status = \'open\' AND awf.employee_id = e.id");
		
		
		  return query2.list();
  
	}
	
	@Override
	public List<ResultPersonalDocumentEmployee> getEnhancedPersonalDocuments() {
		
			
		  Query<ResultPersonalDocumentEmployee> query2 = getCurrentSession().createQuery(
					"select new com.group6project.hr.domains.ResultPersonalDocumentEmployee(e.firstName, e.lastName, e.email,  pd.id, pd.employee_id, pd.path, pd.title, pd.comment, pd.createdDate, pd.filename) "
				  
					+ "FROM PersonalDocument6 pd, Employee e WHERE pd.employee_id = e.id");
		
		
		  return query2.list();
  
	}
	
	
	@Override
	public  PersonalDocument6  getPersonalDocumentByIdAndTitle(Integer eid) {
		
	 		 	
		Query query =  getCurrentSession().createQuery("FROM PersonalDocument6 WHERE employee_id = :eid AND (title like '%pending%'  )");
 
		 query.setParameter("eid", eid);
		  
		  if(query.list() != null && query.list().size() > 0) {
			  return (PersonalDocument6) query.getSingleResult();
		  }
		  
		  Query query2 =  getCurrentSession().createQuery("FROM PersonalDocument6 WHERE employee_id = :eid AND  (title like '%I-983 Waiting For Approval%' )");
		  
		  query2.setParameter("eid", eid);
		  
		  if(query2.list() != null && query2.list().size() > 0) {
			  return (PersonalDocument6) query2.getSingleResult();
		  }
		  
		  	return null;
	}
	
	

	@Override
	public List<Employee6> getEmployees(int id) {
		
		  Query<Employee6> query2 = getCurrentSession().createQuery(
					"select e FROM Employee6 e WHERE e.id = :empid");
		  
		  query2.setParameter("empid", id);
		  List<Employee6> css =   query2.list() ;
		  
		  System.out.println("bug checks getEmployee by id is not null :" + css);
		  
		  return css;
	}
	
	@Override
	public List<Address6> getAddressById(int id) {
		
		 Query<Address6> query2 = getCurrentSession().createQuery(
					"select a "
				  
					+ "FROM Address6 a WHERE a.employee_id  = :empid");
		  
		  query2.setParameter("empid", id);
		  List<Address6> addresses =   query2.list() ;
		  
		  System.out.println("bug checks getAddressById by id is not null :" + addresses);
		  
		  return addresses;
	}
	
	
	@Override
	public List<Contact6> getRefById(int id) {
		
		 Query<Contact6> query2 = getCurrentSession().createQuery(
					"select c "
				  
					+ "FROM Contact6 c WHERE c.employee_id  = :empid AND c.isReference =1 ");
		  
		  query2.setParameter("empid", id);
		  List<Contact6> contacts =   query2.list() ;
		  
		  System.out.println("bug checks getRefById by id is not null :" + contacts);
		  
		  return contacts;
	}
	
	@Override
	public List<Contact6> getEmergencyById(int id) {
		
		 Query<Contact6> query2 = getCurrentSession().createQuery(
					"select c "
				  
					+ "FROM Contact6 c WHERE c.employee_id  = :empid AND c.isEmergency =1 ");
		  
		  query2.setParameter("empid", id);
		  List<Contact6> contacts =   query2.list() ;
		  
		  System.out.println("bug checks getEmergencyById by id is not null :" + contacts);
		  
		  return contacts;
	}

	@Override
	public void approveApplication(Integer employeeId, String comments) {
	 
		
		ApplicationWorkFlow6  awf = null;
		String sql = "FROM ApplicationWorkFlow6 WHERE employee_id = "+ employeeId + " and status like '%Open%' "  ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	awf = (ApplicationWorkFlow6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("awf does not exist with employee id");
        }
		
        
        if(awf !=null) {
        	
        	awf.setComments(comments);
        	awf.setStatus("Completed");
        	
        	Date date = new Date();
        	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        	awf.setModificationDate(modifiedDate);
        	
        	getCurrentSession().update(awf);
        	
        }
		// TODO Auto-generated method stub
		return;
		
		
	}
	
	@Override
	public void approveDocument(Integer fileid ) {
	 
		
		PersonalDocument6  pd = null;
		String sql = "FROM PersonalDocument6 WHERE id = "+ fileid    ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	pd = (PersonalDocument6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("awf does not exist with employee id");
        }
		
        
        if(pd !=null) {
        	
        	String currentTitle = pd.getTitle();
        	currentTitle = currentTitle.replace(" pending", " approved");
        	currentTitle = currentTitle.replace(" rejected", "	approved");
        	
        	pd.setTitle(currentTitle);
        	
        	 
        	getCurrentSession().update(pd);
        	
        }
		// TODO Auto-generated method stub
		return;
		
		
	}
	
	@Override
	public void rejectedDocument(Integer fileid ) {
	 
		
		PersonalDocument6  pd = null;
		String sql = "FROM PersonalDocument6 WHERE id = "+ fileid    ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	pd = (PersonalDocument6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("awf does not exist with employee id");
        }
		
        
        if(pd !=null) {
        	
        	String currentTitle = pd.getTitle();
        	currentTitle = currentTitle.replace(" pending", " rejected");
        	currentTitle = currentTitle.replace(" rejected", " rejected");
        	
        	pd.setTitle(currentTitle);
        	
        	 
        	getCurrentSession().update(pd);
        	
        }
		// TODO Auto-generated method stub
		return;
		
		
	}

	@Override
	public void rejectApplication(Integer employeeId, String comments) {
		ApplicationWorkFlow6  awf = null;
		String sql = "FROM ApplicationWorkFlow6 WHERE employee_id = "+ employeeId+" and status like '%Open%'";
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	awf = (ApplicationWorkFlow6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("awf does not exist with employee id");
        }
		
        
        if(awf !=null) {
        	
        	awf.setComments(comments);
        	awf.setStatus(" Rejected");
        	
        	Date date = new Date();
        	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        	awf.setModificationDate(modifiedDate);
        	
        	getCurrentSession().update(awf);
        	
        }
		// TODO Auto-generated method stub
		return;
		
	}

	@Override
	public void addDocumentComment(Integer id, String comment) {
		
		PersonalDocument6  pd = null;
		String sql = "FROM PersonalDocument6 WHERE  id = "+ id ;
		Query query =  getCurrentSession().createQuery(sql);
		
        try {
        	pd = (PersonalDocument6) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("personal document does not exist with employee id");
        }
        
        pd.setComment(comment);
        getCurrentSession().update(pd);
 
		
	}



 
	
	
	

}
