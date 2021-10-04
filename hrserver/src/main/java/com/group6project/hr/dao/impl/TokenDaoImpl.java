package com.group6project.hr.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.TokenDao;
import com.group6project.hr.domains.RegistrationToken;
import com.group6project.hr.domains.RegistrationToken6;
 
 
 
 

@Repository 
public class TokenDaoImpl extends AbstractHibernateDao<RegistrationToken6> implements TokenDao{

	@Override
	public void generateToken() {
		
			
		


		
	}

	@Override
	public List<RegistrationToken> getToken(String token) {
		
	 
	 
		
		
		Query q = getCurrentSession().createQuery("SELECT t FROM RegistrationToken t WHERE t.token = \'" +token + "\' " , RegistrationToken6.class);
		 
		  return q.list();      


		 
	}

	@Override
	public void saveToken(RegistrationToken6 token) {
		 
		getCurrentSession().save(token);
		
	}

	@Override
	public void saveToken(RegistrationToken token) {
		
		 getCurrentSession().save(token);
		
	}

	@Override
	public List<RegistrationToken6> getToken6(String token) {
		Query q = getCurrentSession().createQuery("SELECT t FROM RegistrationToken6 t WHERE t.token = \'" +token + "\' " , RegistrationToken6.class);
		 
		  return q.list();      

	}

	@Override
    public RegistrationToken getSingleToken(String token) {

        Query q = getCurrentSession().createQuery("SELECT t FROM RegistrationToken t WHERE t.token = '" +token + "' " , RegistrationToken.class);

        return (RegistrationToken) q.getSingleResult();
    }
	
	

}
