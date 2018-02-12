package com.sierrica.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex){

      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body("Requested resource does not found");
    }

    @ExceptionHandler(InvalidInputException.class)
    protected ResponseEntity<String> handleInvalidInput(InvalidInputException ex) {

      return ResponseEntity
              .badRequest()
              //.contentType(arg0)
              .body("Invalid Input");
    }
}