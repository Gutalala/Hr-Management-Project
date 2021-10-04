package com.group6.employeeonboarding.controllers;


import com.group6.employeeonboarding.Response.TokenResponse;
import com.group6.employeeonboarding.Common.ResponseStatus;
import com.group6.employeeonboarding.domains.Employee;
import com.group6.employeeonboarding.domains.RegistrationToken;
import com.group6.employeeonboarding.domains.User;
import com.group6.employeeonboarding.service.EmployeeOnboardingService;
import com.group6.employeeonboarding.service.TokenService;
import com.group6.employeeonboarding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class OnboardingController {

    EmployeeOnboardingService employeeOnboardingService;

    TokenService tokenService;

    UserService userService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @Autowired
    public void setEmployeeOnboardingService(EmployeeOnboardingService employeeOnboardingService){this.employeeOnboardingService = employeeOnboardingService;}

    @Autowired
    public void setTokenService(TokenService tokenService){this.tokenService = tokenService;}

    @PostMapping("/api/onboarding")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        try {
            this.employeeOnboardingService.addEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/api/accountToken")
    public TokenResponse getToken(@RequestBody String token){
        TokenResponse response = new TokenResponse();

        Optional<RegistrationToken> matchedToken =  Optional.ofNullable(tokenService.getSingleToken(token));

        if (!matchedToken.isPresent()){
            ResponseStatus status = new ResponseStatus(false, "No matched account found");
            response.setResponseStatus(status);
            return response;
        }

        ResponseStatus status = new ResponseStatus(true, "Matched account found");
        response.setRegistrationToken(matchedToken.get());
        response.setResponseStatus(status);
        return response;
    }

    @PostMapping("/api/addUser")
    public ResponseEntity addUser(@RequestBody User user){
        try {
            System.out.println(user);
            int user_id = this.userService.addUser(user);
            return new ResponseEntity<>(user_id, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("user error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
