package com.group6project.hr.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group6project.hr.domains.ApplicationWorkFlow6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.PersonalDocument6;
import com.group6project.hr.domains.ResultPersonalDocumentEmployee;
import com.group6project.hr.domains.VisaStatus6;
import com.group6project.hr.response.EmployeeFullVisaInfo;
import com.group6project.hr.response.VisaDocument;
import com.group6project.hr.service.impl.HireService;
import com.group6project.hr.service.impl.VisaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VisaController {
	
	VisaService visaService;
	HireService hireService; 
	VisaController(VisaService visaService, HireService hireService){
		
		this.visaService = visaService;
		this.hireService = hireService;
		
	}
	
	
	
	   @GetMapping("/getempid/{uid}")
	    public int getToken(@PathVariable Integer uid){
		   
		   return visaService.getEmployeeId(uid);
		   
		   
	   }
	   
	   @GetMapping("/getvisastatus/{eid}")
	    public VisaStatus6 getVisaStatus(@PathVariable Integer eid){
		   
		   return visaService.getVisaStatus(eid);
 
	   }
	   
	   @GetMapping("/getvisastatus2/{eid}")
	    public String getVisaStatus2(@PathVariable Integer eid){
		   
		   ApplicationWorkFlow6 awf = visaService.getOptStatus(eid);
		   
		   return awf.getStatus();

	   }
	   
	   
	   @GetMapping("/changeoptstatus")
	    public int changeOptStatus(@RequestParam Integer empid, @RequestParam String status){
		   System.out.println("changeoptstatus empid is : " + empid);
		   System.out.println("changeoptstatus status is : " + status);
		   
		   visaService.changeOptStatus(empid, status);
		   
		   return 200;

	   }
	   
	   @GetMapping("/getallpersonaldocuments/{eid}")
	    public List<PersonalDocument6> getAllPersonalDocuments(@PathVariable Integer eid){
		   
		  return visaService.getAllPersonalDocuments(eid);
 
	   }
	   
	   
	   @GetMapping("/geti983byempid/{eid}")
	    public  PersonalDocument6  geti983byempid(@PathVariable Integer eid){
		   
		  return visaService.geti983ByEmployeeid(eid);

	   }
	   
	   
	   
	   @GetMapping("/getallpendingpersonaldocuments")
	    public List<ResultPersonalDocumentEmployee> getallPendingPersonalDocuments(){
		   
		   List<ResultPersonalDocumentEmployee> allPersonalDocuments = new ArrayList<>();
		   List<ApplicationWorkFlow6> awfs = visaService.getAllAWFWhichNeedsNotificationFile();
		   
		   List<Integer> employeeIds = new ArrayList<>();
		   
		   if(awfs != null && awfs.size() > 0) {
			   
					   for(ApplicationWorkFlow6 awf : awfs) {
						   
						   	employeeIds.add(awf.getEmployee_id());
						   
					   }
			   
			   
		   }
		   
		   for (Integer empId :employeeIds) {
			   
			   ResultPersonalDocumentEmployee singleResult = new ResultPersonalDocumentEmployee();
			   Employee6 tempEmp = hireService.getEmployeesById(empId).get(0);
			   singleResult.setFirstName(tempEmp.getFirstName());
			   singleResult.setLastName(tempEmp.getLastName());
			   singleResult.setEmail(tempEmp.getEmail());
			   
			   PersonalDocument6 pd  = hireService.getPersonalDocumentByIdAndTitle(empId);
			   
			   singleResult.setId(pd.getId());
			   
			   singleResult.setEmployee_id(pd.getEmployee_id());
			   singleResult.setPath(pd.getPath());
			   singleResult.setTitle(pd.getTitle());
			   singleResult.setComment(pd.getComment());
			   singleResult.setCreatedDate(pd.getCreatedDate());
			   singleResult.setFilename(pd.getFilename());
			   
			   allPersonalDocuments.add(singleResult);
		   }
		   
		   
		   
		   
		   
		   
		   return allPersonalDocuments;
	   }
	   
	   @GetMapping("/getallemployeevisadata")
	    public List<EmployeeFullVisaInfo> getAllEmployeeVisaData(){
		   
		   List<EmployeeFullVisaInfo> allEmployeeFullVisaInfo = new ArrayList<>();
		   
		   // get all awfs which need notification.
		   
		   List<ApplicationWorkFlow6> awfs = visaService.getAllAWFWhichNeedsNotification();
		   
		   // store all employee whose visa status needs notifications to a list.
		   
		   List<Integer> employeeIds = new ArrayList<>();
		   
		   if(awfs != null && awfs.size() > 0) {
			   
			   for(ApplicationWorkFlow6 awf : awfs) {
				   
				   	employeeIds.add(awf.getEmployee_id());
				   
			   }
			
		   // for each employee  fill out EmployeeFullVisaInfo
			   
		   for (Integer empId :employeeIds) {
			   	
			   EmployeeFullVisaInfo tempEmpData = new EmployeeFullVisaInfo();
			   tempEmpData.setEmployeeId(empId);
			   // 1 get name from Employee table
			   	
			      Employee6 tempEmp = hireService.getEmployeesById(empId).get(0);
			      tempEmpData.setFirstname(tempEmp.getFirstName());
			      tempEmpData.setLastname(tempEmp.getLastName());
			      
			      tempEmpData.setEmail(tempEmp.getEmail());
			   // 2 get data from VisaStatus table
			      
			      VisaStatus6 ts = visaService.getVisaStatus(empId);
			      
			      tempEmpData.setVisaType(ts.getVisaType());
			      tempEmpData.setStartDate(ts.getVisaStartDate());
			      tempEmpData.setEndDate(ts.getVisaEndDate());
			     
			     
			   // 3 get data from application work flow
			      
			      ApplicationWorkFlow6 ta = visaService.getOptStatus(empId);
			      tempEmpData.setVisaStatus(ta.getStatus());
			      
			   
			   // 4. set actionrequired to "" may change later
			      
			      tempEmpData.setActionRequired("");
			      
			    
			    // 5. calculate days left
			      SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			      String endDate = ts.getVisaEndDate();
			      String startDate = ts.getVisaStartDate();

			      try {
			          Date date1 = myFormat.parse(startDate);
			          Date date2 = myFormat.parse(endDate);
			          long diff = date2.getTime() - date1.getTime();
			          Integer dayleft = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			          System.out.println ("Days: " +  dayleft);
			          tempEmpData.setDayLeft(dayleft);
			      } catch (ParseException e) {
			          e.printStackTrace();
			      }
			    
			   // 6. add documents
			      
			      List<VisaDocument> visaDocuments = new ArrayList<>();
			      
			      List<PersonalDocument6> pds = visaService.getAllPersonalDocuments(empId);
			      
			      for(PersonalDocument6 p : pds) {
			    	  
			    	  VisaDocument tv= new VisaDocument();
			    	  
			    	  tv.setIconname("pdf/word");
			    	  tv.setFilename(p.getFilename());
			    	  visaDocuments.add(tv);
			      }
			      tempEmpData.setVisaDocuments(visaDocuments);
			      
			      
			      
			      
			      
			      allEmployeeFullVisaInfo.add(tempEmpData);
		   }
			   
			//
			  // System.out.println(awfs);
			   
		   }
		   
		   
		   
		   
		   return allEmployeeFullVisaInfo;

	   }

	   
	   
	   
}
