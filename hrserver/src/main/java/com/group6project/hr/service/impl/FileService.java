package com.group6project.hr.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.multipart.MultipartFile;

import com.group6project.hr.domains.PersonalDocument;

public interface FileService {
	
	int saveDocument(String title,  MultipartFile file , int employeeId);

    byte[] downloadDocument(Integer id);

    List<PersonalDocument> getAllDocument();
    
   

}
