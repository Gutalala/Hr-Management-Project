package com.group6project.hr.controllers;


import com.google.gson.Gson;
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.VisaStatus6;
import com.group6project.hr.response.AsyncHireResponse;
import com.group6project.hr.response.EmployeeResponse;
import com.group6project.hr.response.ResponseStatus;
import com.group6project.hr.service.impl.AsyncHireService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AsyncHireController {

    private AsyncHireService asyncHireService;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){this.rabbitTemplate = rabbitTemplate;}

    @Autowired
    public void setAsyncHireService(AsyncHireService asyncHireService){this.asyncHireService = asyncHireService;}


    @GetMapping("async/getemployeeinfo/{eid}")
    public EmployeeResponse getAsyncEmployeeInfo(@PathVariable Integer eid){

        EmployeeResponse employeeResponse= new EmployeeResponse();
        AsyncHireResponse asyncHireResponse = asyncHireService.asyncCall(eid);

        List<Employee6> emps = asyncHireResponse.getEmployeeResponse();

        Employee6 emp = emps.get(0);

        List<Address6> addrs = asyncHireResponse.getAddressResponse();
        Address6 addr = addrs.get(0);

        List<Contact6> contacts = asyncHireResponse.getRefsResponse();
        Contact6  contact = null;

        VisaStatus6 visaStatus = asyncHireResponse.getVisaStatusResponse();
        employeeResponse.setVisatype(visaStatus.getVisaType());

        if(contacts.size() ==0 ) {

            employeeResponse.setReference(null);

        }
        else {
            contact = contacts.get(0);
            employeeResponse.setReference(contact);
        }

        List<Contact6> emergencyContacts = asyncHireResponse.getEmergencyResponse();

        employeeResponse.setStatus(new ResponseStatus(true,"successful"));
        employeeResponse.setEmployee(emp);
        employeeResponse.setAddress(addr);
        employeeResponse.setContacts(emergencyContacts);

        Gson gson = new Gson();

//        rabbitTemplate.convertAndSend("casperExchange", "casper.EmployeeHire",gson.toJson(employeeResponse));

        return employeeResponse;

    }
}
