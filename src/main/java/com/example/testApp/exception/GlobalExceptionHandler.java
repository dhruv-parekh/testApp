package com.example.testApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> RestrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementErrorMsg(){
        return new ResponseEntity<>("Error in input. no such value found.", HttpStatus.BAD_REQUEST);
    }

}
