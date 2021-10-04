package com.group6project.hr.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group6project.hr.config.BucketName;
import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.FileRepository;
import com.group6project.hr.dao.HireDao;
import com.group6project.hr.dao.VisaManagementDao;
import com.group6project.hr.domains.ApplicationResult1;
import com.group6project.hr.domains.PersonalDocument;
import com.group6project.hr.domains.PersonalDocument6;

import lombok.AllArgsConstructor;
import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class FileServiceImpl extends AbstractHibernateDao<PersonalDocument6> implements FileService{
	private final FileStore fileStore;
	
 
	
  
	
 @Autowired
 VisaManagementDao visaManagementDao;
 
 @Autowired
 HireDao hireDao;
 
	 
	
	@Override
	public int saveDocument(String title , MultipartFile file, int employeeId) {
	

						 
					 if (file.isEmpty()) {
				         throw new IllegalStateException("Cannot upload empty file");
				     }
					 
				     //Check if the file is valid format  * already done in front end
//				     if (!Arrays.asList(IMAGE_PNG.getMimeType(),
//				             IMAGE_BMP.getMimeType(),
//				             IMAGE_GIF.getMimeType(),
//				             IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
//				         throw new IllegalStateException("FIle uploaded is not an image");
//				     }
				     
				     Map<String, String> metadata = new HashMap<>();
				     metadata.put("Content-Type", file.getContentType());
				     metadata.put("Content-Length", String.valueOf(file.getSize()));
				     
				     String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
				     String fileName = String.format("%s", file.getOriginalFilename());
				     
				     try {
				         fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
				     } catch (IOException e) {
				         throw new IllegalStateException("Failed to upload file", e);
				     }
				     
				     
				     	Date date = new Date();
			        	String createdDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
			        	PersonalDocument6 personalDocument = PersonalDocument6.builder()
				                .employee_id(employeeId)
				                .title(title)
				                .path(path)
				                .filename(fileName) 
				                .comment("")
				                .createdDate(createdDate)
				                .build();
				  	
				  getCurrentSession().save(personalDocument);
				    
				        return 200;
	
	
	}

	@Override
	public byte[] downloadDocument(Integer id) {
         	PersonalDocument6 personalDocument = visaManagementDao.getSinglePersonalDocument(id);
            return fileStore.download(personalDocument.getPath(), personalDocument.getFilename());
		
 
	}

	@Override
	public List<PersonalDocument> getAllDocument() {
//        List<PersonalDocument> personalDocuments = new ArrayList<>();
//        repository.findAll().forEach(personalDocuments::add);
        return null;
	}



}
