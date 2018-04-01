package com.sierrica.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sierrica.exception.custom.InvalidInputException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionController {


	
    @ExceptionHandler({InvalidInputException.class})
    protected ResponseEntity<ExceptionResponse> handleInvalidInput(InvalidInputException ex) {
        ExceptionResponse response = new ExceptionResponse (HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value={DataIntegrityViolationException.class})
    public ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException (DataIntegrityViolationException ex) {
		LOG.error(ex.getStackTrace().toString());
        ExceptionResponse response = new ExceptionResponse (HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }
	
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		LOG.error(ex.getStackTrace().toString());
        ExceptionResponse response = new ExceptionResponse (HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }


    
    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<ExceptionResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse (HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({RuntimeException.class, Exception.class})
    protected ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse (HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}