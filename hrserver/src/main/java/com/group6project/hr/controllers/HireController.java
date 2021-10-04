package com.group6project.hr.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6project.hr.response.AsyncHireResponse;
import com.group6project.hr.service.impl.AsyncHireService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.ApplicationResult1;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.RegistrationToken6;
import com.group6project.hr.domains.ResultPersonalDocumentEmployee;
import com.group6project.hr.domains.VisaStatus6;
import com.group6project.hr.request.ApplicationApproveRequest;
import com.group6project.hr.request.DocumentCommentRequest;
import com.group6project.hr.response.EmployeeResponse;
import com.group6project.hr.response.ResponseStatus;
import com.group6project.hr.security.JwtUtil;
import com.group6project.hr.service.impl.EmailService;
import com.group6project.hr.service.impl.HireService;
import com.group6project.hr.service.impl.VisaService;
 
 

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HireController {
	
	HireService hireService;
	EmailService emailService;
	VisaService visaService;
	
	HireController(HireService hireService,EmailService emailService, VisaService visaService){
		
		this.hireService = hireService;
		this.emailService = emailService;
		this.visaService = visaService;
		
	}
	
	
    @GetMapping("/gettoken")
    public String getToken(@RequestParam String email){
    	
    	String token = JwtUtil.generateToken("happygroup6", email);
    	
    	token = token.replaceAll("\\.", "");
    	
     
    	
    	long validDuration = 60 * 1000 *  60 * 3;
    	
    	long now = System.currentTimeMillis();
    	
    	RegistrationToken6 newToken = new RegistrationToken6();
    	
    	
    	
    	newToken.setEmail(email);
    	newToken.setValidDuration(String.valueOf(validDuration));
    	newToken.setCreatedBy(String.valueOf(now));
    	newToken.setToken(token);
    	
     
    // Getting database setup and save
    	
//    	  ApplicationContext context = new AnnotationConfigApplicationContext(GeneralConfig.class);
//    	  HireService hireService = context.getBean("hireService", HireService.class);
    	  
    	  System.out.println("bug check is hireService null?: " + hireService);
    	  
          hireService.saveToken(newToken);
    	  
    	  // send an email with token included 
          

      	String subject = "Here is your registration token" + email.split("@")[0];
      	String emailBody = "Hi" + email + "Here is your token: " + token ;
      	
      	emailService.sendEmail(email, subject, emailBody);
      	
      	

        return token;
    }
    
    
    //status code
    // 404 token not exist
    // 200 valid token
    // 503 expired token
    
    
    @GetMapping("/checktoken")
    public int checkToken(@RequestParam String token){
    	
    	
    	//check if it exists 
    	RegistrationToken6 currentToken = null;
    	
    	List<RegistrationToken6> tempTokens = hireService.getToken(token);
    	
    	if(tempTokens.size() ==0) {
    		
    		return 404;
    		
    	}
    	else {
    		currentToken = tempTokens.get(0);
    		System.out.println("bug check currentToken is ?: " + currentToken);
    		
    	}
    	
    	long currentTime = System.currentTimeMillis();
    	long validDuration = Long.parseLong(currentToken.getValidDuration());
    	long createdTime = Long.parseLong(currentToken.getCreatedBy());
    	
    	if(Math.abs(currentTime - createdTime) > validDuration) {
    		
    		return 503;
    		
    	}
    	
    	
    	  return 200;

//    	
//    	String token = JwtUtil.generateToken("happygroup6", email);
//    	
//    	long validDuration = 60 * 60 * 3;
//    	
//    	long now = System.currentTimeMillis();
//    	
//    	RegistrationToken newToken = new RegistrationToken();
//    	newToken.setEmail(email);
//    	newToken.setValidDuration(String.valueOf(validDuration));
//    	newToken.setCreatedBy(String.valueOf(now));
//    	newToken.setToken(token);
//    	
//     
//    // Getting database setup and save
//    	
////    	  ApplicationContext context = new AnnotationConfigApplicationContext(GeneralConfig.class);
////    	  HireService hireService = context.getBean("hireService", HireService.class);
//    	  
//    	  System.out.println("bug check is hireService null?: " + hireService);
//    	  
//          hireService.saveToken(newToken);
//    	  
//    	  // send an email with token included 

      
    }
    
    
// Get application list  open status
    
    @GetMapping("/getapplications")
    public List<ApplicationResult1> getApplications( ){
    	
    	return hireService.getApplications();
    	
    }
    
    // EmployeeResponse has 5 fields to set
    @GetMapping("/getemployeeinfo/{eid}")
    public EmployeeResponse getEmployeeInfo(@PathVariable Integer eid){

    	EmployeeResponse employeeResponse= new EmployeeResponse();

    	List<Employee6> emps = hireService.getEmployeesById(eid);
    	Employee6 emp = emps.get(0);

    	List<Address6> addrs = hireService.getAddressesById(eid);
    	Address6 addr = addrs.get(0);

    	List<Contact6> contacts = hireService.getRefById(eid);
    	 Contact6  contact = null;

    	 VisaStatus6 visaStatus = visaService.getVisaStatus(eid);
    	 employeeResponse.setVisatype(visaStatus.getVisaType());

		List<Contact6> emergencyContacts = hireService.getEmergencyById(eid);
    	
    	if(contacts.size() ==0 ) {
    		
    		employeeResponse.setReference(null);
    		
    	}
    	else {
    		contact = contacts.get(0);
    	 	employeeResponse.setReference(contact);
    	}
    	
    	employeeResponse.setStatus(new ResponseStatus(true,"successful"));
    	employeeResponse.setEmployee(emp);
    	employeeResponse.setAddress(addr);
    	employeeResponse.setContacts(emergencyContacts);
    	
    	return employeeResponse;
    	
    }

    
    @PostMapping("/applicationreview")
    public int applicationreview(@RequestBody ApplicationApproveRequest request, HttpServletResponse httpServletResponse){
    	
    	Integer employeeId = request.getEmployeeid();
    	String comments = request.getComments();
    	
    	
    	System.out.println("employee id :" + employeeId);
    	
     	System.out.println("comments :" + comments);
     	
     	
     	hireService.approveApplication(employeeId, comments);
     	
     	
    	
    	return 200;
    	
    }
    
    @PostMapping("/rejectApplication")
    public int rejectApplication(@RequestBody ApplicationApproveRequest request, HttpServletResponse httpServletResponse){
    	
    	Integer employeeId = request.getEmployeeid();
    	String comments = request.getComments();
    	
    	
    	System.out.println("employee id :" + employeeId);
    	
     	System.out.println("comments :" + comments);
     	
     	
     	hireService.rejectApplication(employeeId, comments);
     	
     	
    	
    	return 200;
    	
    }
    
    @GetMapping("/approvedocument")
    public void  approveDocument( @RequestParam Integer eid, @RequestParam Integer fileid){
    	
    	String currentStatus = visaService.getOptStatus(eid).getStatus();
    	
    	if(currentStatus.contains("pending")) {
    	
    	visaService.changeOptStatus(eid, currentStatus.replace(" pending", ""));
    	}
    	else if(currentStatus.contains("rejected")) {
    		visaService.changeOptStatus(eid, currentStatus.replace(" rejected", ""));
    	}
    	
    	hireService.approveDocument(fileid);
     
    	
    }
    
    @GetMapping("/rejectdocument")
    public void  rejectdocument( @RequestParam Integer eid, @RequestParam Integer fileid){
    	
    	String currentStatus = visaService.getOptStatus(eid).getStatus();
    	
    	
    	visaService.changeOptStatus(eid, currentStatus.replace(" pending", "rejected"));
    	
    	
    	hireService.rejectedDocument(fileid);
    }
    
    
    
    @GetMapping("/testsendemail")
    public void  testsendemail( ){
    	
    	emailService.sendEmail("tobybfs@aol.com", "test send 1  group 6", "here is your token from group 6 members");
    	
    	return  ;
    	
    }
    
    @GetMapping("/sendtokenemail")
    public void  sendTokenEmail(@RequestParam String email, @RequestParam String token){
    	
    	
    	
    	String subject = "Here is your registration token" + email.split("@")[0];
    	String emailBody = "Hi" + email + "Here is your token: " + token ;
    	
    	emailService.sendEmail(email, subject, emailBody);
    	
    	return  ;
    	
    }
    
    @GetMapping("/sendnotificationemail")
    public void  sendNotificationEmail( @RequestParam String status,@RequestParam String email  ){
    	
    	String subject = "";
    	String emailBody = "";
    	
    	if(status.equalsIgnoreCase("optreceipt")) {
    		
    		  subject = "Hi " + email.split("@")[0] +  " Action Required: Please upload a copy of your OPT EAD"  ;
    	      emailBody = "Hi," + email + " Please upload a copy of your OPT EAD. "  ;

    	}
    	
    	if(status.equalsIgnoreCase("optead")) {
    		
  		  subject = "Hi " + email.split("@")[0] +  " Action Required: Please upload a copy of your OPT EAD"  ;
  	      emailBody = "Hi," + email + " Please upload a copy of your OPT EAD. "  ;

    	}
    	
    	if(status.equalsIgnoreCase("i983approved")) {
    		
    		  subject = "Hi " + email.split("@")[0] +  " Action Required: Please upload your new I-20"  ;
    	      emailBody = "Hi," + email + " Please send the I-983 with all necessary documents to your school and upload the new I-20. "  ;

      	}
    	
    	if(status.equalsIgnoreCase("i20")) {
    		
  		  subject = "Hi " + email.split("@")[0] +  " Action Required: Please upload your OPT STEM Receipt"  ;
  	      emailBody = "Hi," + email + " Please upload your OPT STEM Receipt. "  ;

    	}
    	
    	if(status.equalsIgnoreCase("optstemreceipt")) {
    		
    		  subject = "Hi " + email.split("@")[0] +  " Action Required: Please upload your OPT STEM EAD"  ;
    	      emailBody = "Hi," + email + " Please upload your OPT STEM EAD. "  ;

      	}
    	
    	
    	
    	
    	
    	
    	
    
    	emailService.sendEmail(email, subject, emailBody);
    	
    	return  ;
    	
    }
    
    @GetMapping("/getalldocuments")
    public List<PersonalDocument6>  getAllDocuments( ){
    	
    	
    	
    	return visaService.getAllDocuments();
 
    }
    
    @GetMapping("/getallenhanceddocuments")
    public List<ResultPersonalDocumentEmployee>  getAllEnhancedPersonalDocuments( ){
    	
    	
    	
    	return visaService.getAllEnhancedPersonalDocuments();
 
    }
    
    
    @PostMapping("/adddocumentcomment")
    public int addDocumentComment(@RequestBody DocumentCommentRequest request, HttpServletResponse httpServletResponse){
    	
    	
    	Integer employeeId = request.getEmployeeid();
    	String comment = request.getComment();
    	
   	
     	System.out.println("comment :" + comment);
     	
     	
     	hireService.addDocumentComment(employeeId, comment);;
     	
     	
    	
    	return 200;
    	
    }
    
    
    
    
    
    
    
    
	

}
