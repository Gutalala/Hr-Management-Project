package com.group6project.hr.controllers;

import java.io.IOException;

import com.group6project.hr.service.impl.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class FileController {
	 private final AmazonS3 amazonS3;
	FileService service;
	
//    @GetMapping
//    public ResponseEntity<List<PersonalDocument6>> getPersonalDocuments() {
//        return new ResponseEntity<>(service.getAllDocument(), HttpStatus.OK);
//    }

    
    @PostMapping(
            path = "uploadfile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> saveTodo(@RequestParam("title") String title,
                                         @RequestParam("employeeid") String employeeId,
                                         @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.saveDocument(title, file , Integer.parseInt(employeeId)), HttpStatus.OK);
    }
    
    
    
    @GetMapping(value = "{id}/document/download")
    public byte[] downloadTodoImage(@PathVariable("id") int id) {
        return service.downloadDocument(id);
    }
    
    
	private static final String FILE_PATH = "https://spring-amazon-storage-group6.s3.us-east-2.amazonaws.com/040348e9-b86f-4619-92b2-6a387e61c862/I-983.pdf";
	 
	@GetMapping(
			  value = "/getfile",
			  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			)
	 public @ResponseBody byte[] getFile() throws IOException {
        try {
            S3Object object = amazonS3.getObject("spring-amazon-storage-group6/a4821996-f936-40fd-a6b3-fe3e9e6934cb", "I-20.pdf");
            S3ObjectInputStream objectContent = object.getObjectContent();
            return IOUtils.toByteArray(objectContent);
        } catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download the file", e);
        }

	}
    
    
    
    
}
