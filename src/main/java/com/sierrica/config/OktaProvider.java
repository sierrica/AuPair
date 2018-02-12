package com.sierrica.config;


import org.springframework.util.Assert;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserStatus;
import com.okta.spring.config.OktaClientProperties;
import com.okta.spring.config.OktaOAuth2Properties;
import com.sierrica.model.User;

public class OktaProvider implements TokenProvider {

OktaOAuth2Properties oktaOAuth2Properties;
OktaClientProperties oktaClientProperties;
	
    public OktaProvider(OktaOAuth2Properties oktaOAuth2Properties, OktaClientProperties oktaClientProperties) {
    	Assert.notNull (oktaOAuth2Properties.getClientId(),  "Property 'okta.oauth2.clientId' is required.");
    	Assert.notNull (oktaOAuth2Properties.getIssuer(), "Property 'okta.oauth2.issuer' is required.");
    	Assert.notNull (oktaOAuth2Properties.getRedirectUri(),  "Property 'okta.oauth2.redirectUri' is required.");
    	Assert.notNull (oktaClientProperties.getToken(), "Property 'okta.client.token' is required.");
    	Assert.notNull (oktaClientProperties.getOrgUrl(),  "Property 'okta.client.orgUrl' is required.");
    	this.oktaOAuth2Properties = oktaOAuth2Properties;
    	this.oktaClientProperties = oktaClientProperties;

    }
    @Override
    public String getCredentials() {
    	return new String("{" + 
							"\"clientId\":\"" + oktaOAuth2Properties.getClientId() + "\"," +
							"\"issuer\":\"" + oktaOAuth2Properties.getIssuer() + "\"," + 
							"\"url\":\"" + oktaOAuth2Properties.getIssuer().replaceAll("/oauth2/.*", "") + "\"," + 
							"\"redirectUri\":\"" + oktaOAuth2Properties.getRedirectUri() + "\"" + 
    					  "}");
    }


	@Override
	public String signup(User user) {
		// TODO Auto-generated method stub

	    
    	System.out.println("DENTRO OAUTH BACKEND");
    	

    	
    	//Instant instant = Instant.now();

    	
    	Client client = Clients.builder()
    		.setClientCredentials(new TokenClientCredentials(oktaClientProperties.getToken()))
    		.setOrgUrl(oktaClientProperties.getOrgUrl())
    	    .build();
    	
    	
//    	client.getUser(userId)
//    	client.
    	
    	
    	try {
    		
        	com.okta.sdk.resource.user.User user_okta = UserBuilder.instance()
        		//.setLogin(user.getFirstName())
        	    .setEmail(user.getEmail())
        	    
        	    .setFirstName(user.getFirstName())
        	    .setLastName(user.getLastName())
        	    .setPassword(user.getPassword())
        	    //.setMobilePhone("")
        	    .setSecurityQuestion(user.getSecurityQuestion())
        	    .setSecurityQuestionAnswer(user.getSecurityQuestionAnswer())
        	    //.putProfileProperty("division", "Seven") // key/value pairs predefined in the user profile schema
            	.setActive(true)
            	.buildAndCreate(client);
        	
        	String userId = user_okta.getId();
        	UserStatus status = user_okta.getStatus();
        	System.out.println("User created with ID: " + userId);
        	return new String("{" + 
        						"\"state\":\"error\"," + 
        						"\"message\":\"" + "User created with ID: " + userId + "\"" + 
        					  "}");

        	
        	
    	}

    	catch (com.okta.sdk.resource.ResourceException e) {
    		
    		// User with email already exists
    		if (e.getOktaError().getCode().equals("E0000001") &&
    			e.getOktaError().getMessage().contains("Api validation failed: login") &&
    			e.getOktaError().getCauses().toString().contains("An object with this field already exists in the current organization")) {
            		return new String("{" + 
										"\"state\":\"error\"," + 
										"\"message\":\"" + "Un usario ya existe con el email: " + user.getEmail() + "\"" + 
									  "}");


    		}
    		else {
    			System.err.println(e);
    			System.err.println(e.getOktaError());

        		return new String("{" + 
									"\"state\":\"error\"," + 
									"\"message\":\"" + "ERROR DESCONOCIDO: " + e.getOktaError() + "\"" + 
								  "}");
    		}
    	}


	}
	
}