package com.group6project.hr.controllers;

import com.group6project.hr.Exception.InvalidUsernameException;
import com.group6project.hr.dao.EmployeeMongoDBDAO;
import com.group6project.hr.domains.Employee;
import com.group6project.hr.domains.EmployeeMongoDB;
import com.group6project.hr.domains.RegistrationToken;
import com.group6project.hr.domains.User;
import com.group6project.hr.response.ResponseStatus;
import com.group6project.hr.response.TokenResponse;
import com.group6project.hr.service.impl.EmployeeOnboardingService;
import com.group6project.hr.service.impl.TokenService;
import com.group6project.hr.service.impl.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OnboardingController {

    EmployeeMongoDBDAO employeeMongoDBDAO;

    @Autowired
    public void setEmployeeMongoDB(EmployeeMongoDBDAO employeeMongoDBDAO){this.employeeMongoDBDAO = employeeMongoDBDAO;}

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
    @ApiOperation(value = "Add An Employee to MySQL Database", response = ResponseEntity.class)
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        Employee employee1 = new Employee();
        try {
            employee1= this.employeeOnboardingService.addEmployee(employee);
            return new ResponseEntity<>(employee1, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(employee1, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/api/onboardingMongo")
    @ApiOperation(value = "Add An Employee Json Data to MongoDB")
    public void addEmployeeMongo(@RequestBody EmployeeMongoDB employeeMongoDB){
        employeeMongoDBDAO.save(employeeMongoDB);
    }

    @PostMapping(value = "/api/accountToken")
    @ApiOperation(value = "Get A Token from Database if It exists", response = TokenResponse.class)
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
    @ApiOperation(value = "Add User to Database", response = ResponseEntity.class)
    public ResponseEntity addUser(@RequestBody User user) throws InvalidUsernameException{
            try {
                int user_id = this.userService.addUser(user);
                return new ResponseEntity<>(user_id, HttpStatus.CREATED);
            } catch (Exception e){
                throw new InvalidUsernameException(user.getUsername());
            }
    }
}