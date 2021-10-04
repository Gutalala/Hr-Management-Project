package com.group6project.hr.savefiles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

import lombok.Data;

@Table(name = "RegistrationToken")
@Data
@Entity
public class RegistrationToken implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	
	
	  @Column(name="token")
		private String name;
	  
	  @Column(name="validDuration")
		private String validDuration;
	  
	  @Column(name="email")
		private String email;
	  
	  @Column(name="createdBy")
		private String createdBy;

}
