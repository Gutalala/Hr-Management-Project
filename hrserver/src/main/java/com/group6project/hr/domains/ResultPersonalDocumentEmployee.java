package com.group6project.hr.domains;

import java.io.Serializable;

import javax.persistence.Column;

public class ResultPersonalDocumentEmployee implements Serializable{

	
	private String  firstName, lastName, email;
	
	
	
	
	    private int id;

	
	    private int employee_id;
	    

	    private String path;
	    

	    private String title;
	    
	
	    private String comment;
	    
	
	    private String createdDate;
	    
	    private String filename;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getEmployee_id() {
			return employee_id;
		}

		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public ResultPersonalDocumentEmployee() {
			
		}
		
		public ResultPersonalDocumentEmployee(String firstName, String lastName, String email, int id, int employee_id,
				String path, String title, String comment, String createdDate, String filename) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.id = id;
			this.employee_id = employee_id;
			this.path = path;
			this.title = title;
			this.comment = comment;
			this.createdDate = createdDate;
			this.filename = filename;
		}
	    

	
}
