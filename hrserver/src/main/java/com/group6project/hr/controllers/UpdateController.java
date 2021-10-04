package com.group6project.hr.controllers;

import com.group6project.hr.domains.Address;
import com.group6project.hr.domains.Contact;
import com.group6project.hr.domains.Employee;
import com.group6project.hr.domains.VisaStatus;
import com.group6project.hr.request.AddressRequest;
import com.group6project.hr.request.ContactRequest;
import com.group6project.hr.request.EmployeeRequest;
import com.group6project.hr.request.VisaStatusRequest;
import com.group6project.hr.service.impl.AddressService;
import com.group6project.hr.service.impl.ContactService;
import com.group6project.hr.service.impl.EmployeeService;
import com.group6project.hr.service.impl.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UpdateController {

    private EmployeeService employeeService;
    private AddressService addressService;
    private ContactService contactService;
    private VisaStatusService visaStatusService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {this.employeeService = employeeService;}

    @Autowired
    public void setAddressService(AddressService addressService) {this.addressService = addressService;}

    @Autowired
    public void setContactService(ContactService contactService) {this.contactService = contactService;}

    @Autowired
    public void setVisaStatusService(VisaStatusService visaStatusService) {this.visaStatusService = visaStatusService;}

    @PostMapping("/updateEmployee")
    public void doPostUpdateEmployee(@RequestBody Employee employeeRequest){
        Employee employee = employeeRequest;
        employeeService.updateEmployee(employee);
    }

    @PostMapping("/updateAddress")
    public void doPostUpdateAddress(@RequestBody AddressRequest addressRequest){
        System.out.println("In post update address");
        Address address = addressRequest.getAddress();
        addressService.updateAddress(address);
    }

    @PostMapping("/updateContact")
    public void doPostUpdateContact(@RequestBody ContactRequest contactRequest){
        Contact[] contacts = contactRequest.getContact();

        contactService.updateContacts(contacts);
    }

    @PostMapping("/updateVisaStatus")
    public void doPostUpdateVisaStatus(@RequestBody VisaStatusRequest visaStatusRequest){
        VisaStatus visaStatus = new VisaStatus(
                visaStatusRequest.getId(),
                visaStatusRequest.getEmployee_id(),
                visaStatusRequest.getVisaType(),
                visaStatusRequest.getActive(),
                visaStatusRequest.getModificationDate(),
                visaStatusRequest.getVisaStartDate(),
                visaStatusRequest.getVisaEndDate()
        );
        visaStatusService.updateVisaStatus(visaStatus);
    }
}
