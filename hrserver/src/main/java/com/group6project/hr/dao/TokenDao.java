package com.group6project.hr.dao;

import java.util.List;

import com.group6project.hr.domains.RegistrationToken;
import com.group6project.hr.domains.RegistrationToken6;



public interface TokenDao {
	
 
		void saveToken(RegistrationToken6 token);
		
		void saveToken(RegistrationToken token);
		
		 List<RegistrationToken> getToken(String token);

		
		void generateToken();
		
		 List<RegistrationToken6> getToken6(String token);

 
		 RegistrationToken getSingleToken(String token);
		 
}
