package com.sierrica.controller.auth;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okta.spring.config.OktaClientProperties;
import com.okta.spring.config.OktaOAuth2Properties;
import com.sierrica.dao.UserRepository;
import com.sierrica.exception.ExceptionResponse;
import com.sierrica.exception.custom.InvalidInputException;
import com.sierrica.model.Credentials;
import com.sierrica.model.types.StatusType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@Slf4j
@Api(value = "Book API", description = "Book API", produces = "application/json", tags = {"API"})
public class Auth {


@Autowired
UserRepository userRepository;
//LOG.error("Something else is wrong here");

	
private TokenProvider tokenProvider;


    public Auth(@Value("#{@environment['auhtProvider']}") String auhtProvider,
    		           OktaOAuth2Properties oktaOAuth2Properties, OktaClientProperties oktaClientProperties) {
    	
    	Assert.notNull ("auhtProvider",  "Property auhtProvider' is required.");
    	
    	switch (auhtProvider) {
        //case "local":  tokenProvider = new ;
        //         break;
        case "okta": tokenProvider = new OktaProvider(oktaOAuth2Properties, oktaClientProperties);
                 break;
        default: tokenProvider = new OktaProvider(oktaOAuth2Properties, oktaClientProperties);
        		 break;
    	}

    }
    
    
    
    
    @ApiOperation(value = "Retrieves the token provider credentials", notes = "", response = Credentials.class)
    //consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_HTML_VALUE},
    @GetMapping(path="/credentials", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_HTML_VALUE})
    @ResponseStatus(HttpStatus.OK)
  //@ResponseStatus(code=HttpStatus.OK, reason="RAZON DEL ERROR")  // reason solo para errores
    @ResponseBody
    public Credentials getCredentials(@RequestHeader HttpHeaders headers) {
    	System.out.println("REQUESSSSTTT Accept-Encoding: " + headers);
        return tokenProvider.getCredentials();
    }
    
    
    
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    protected ResponseEntity<ExceptionResponse> handleNotFoundException(DataIntegrityViolationException e) {
//    	//throw e;
//    	if (e.getRootCause().getMessage().contains("duplicate key value violates unique constraint")  &&  e.getRootCause().getMessage().contains("email"))
//	    	return new ResponseEntity<ExceptionResponse>(new ExceptionResponse (HttpStatus.BAD_REQUEST.value(), "userAlreadyRegistered"), HttpStatus.BAD_REQUEST);
//		else
//		    return new ResponseEntity<ExceptionResponse>(new ExceptionResponse (HttpStatus.BAD_REQUEST.value(), e.getRootCause().getMessage()), HttpStatus.BAD_REQUEST);
//    }

    

    
    
	
	@PostMapping(path="/signup", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_HTML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    //@Transactional
    public void signup(@Valid @RequestBody com.sierrica.model.User user, Errors errors) {
    	
		// Check errors
		if (errors.hasErrors())
    		throw new InvalidInputException(errors.getFieldError().getDefaultMessage());

		// Save in Database
		try {
			user.setStatus(StatusType.ACTIVE);
			userRepository.save(user);
		}
		catch (DataIntegrityViolationException e) {
			if (e.getRootCause().getMessage().contains("duplicate key value violates unique constraint")  &&  e.getRootCause().getMessage().contains("email"))
				throw new DataIntegrityViolationException("userAlreadyRegistered");
			else
				throw e;
		}
		

		// Token Provider
		try {
			tokenProvider.signup(user);
		}
		catch (InvalidInputException f) {
			userRepository.delete(user);
			throw f;
		}
		catch (RuntimeException g) {
			userRepository.delete(user);
			throw g;
		}
		
		LOG.info("User created with email: " + user.getEmail());
    }
    
    
    
    
    
    
    
    @RequestMapping("/403")
    public String error403() {
    	System.err.println("DENTROOOOOOOOOOOOOO   403");
        return "403";
    }
    
	//userRepository.save(user);
	//UserRepository repository = repository.save(user);
    


}
