package com.sierrica.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okta.spring.config.OktaClientProperties;
import com.okta.spring.config.OktaOAuth2Properties;
import com.sierrica.config.OktaProvider;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
public class Auth {


//@Autowired
//UserRepository userRepository;

private com.sierrica.config.TokenProvider tokenProvider;


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

    @GetMapping("/credentials")
    @ResponseBody()
    @ResponseStatus(value=HttpStatus.OK)
    //@ResponseStatus(code=HttpStatus.OK, reason="RAZON DEL ERROR")  // reason solo para errores
    public String getCredentials() {
        return tokenProvider.getCredentials();
    }
    

    
    
    @RequestMapping("/403")
    public String error403() {
    	System.err.println("DENTROOOOOOOOOOOOOO   403");
        return "403";
    }
    
	//userRepository.save(user);
	//UserRepository repository = repository.save(user);
    

    //public String signup(@RequestBody String user) {
    //public String signup(@Valid @ModelAttribute com.sierrica.model.User user) {
    @PostMapping(value="/signup", consumes = { MediaType.APPLICATION_JSON_VALUE })
    
    //@Transactional(readOnly = true)
    public String signup(@Valid @RequestBody com.sierrica.model.User user) {
    	return tokenProvider.signup(user);

    }
}
