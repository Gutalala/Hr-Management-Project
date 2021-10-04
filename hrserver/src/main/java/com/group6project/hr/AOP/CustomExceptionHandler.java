package com.group6project.hr.AOP;


import com.group6project.hr.Exception.InvalidUsernameException;
import com.group6project.hr.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = {InvalidUsernameException.class})
    public ResponseEntity<ErrorResponse> handleInvalidUsernameException(InvalidUsernameException e){
        String errorMessage = "Username Already Exists: " + e.getMessage();
        log.error(errorMessage);
        return new ResponseEntity(ErrorResponse.builder().message(errorMessage).build(), HttpStatus.OK);
    }

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e){
//        return new ResponseEntity(ErrorResponse.builder().message("Bad Username: " + e.getMessage()).build(), HttpStatus.OK);
//    }

}
