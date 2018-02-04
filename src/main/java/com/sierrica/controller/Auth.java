package com.sierrica.controller;



import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.spring.config.OktaClientProperties;
import com.okta.spring.config.OktaOAuth2Properties;

import javax.validation.Valid;

import org.springframework.http.MediaType;

@RestController
public class Auth {

private final String issuer;
private final  String clientId;
private final  String redirectUri;
private final  String token;
private final  String orgUrl;

//@Autowired
//UserRepository userRepository;


	//public Auth(@Value("#{@environment['okta.oauth2.clientId']}") String clientId, @Value("#{@environment['okta.oauth2.issuer']}") String issuer, @Value("#{@environment['okta.oauth2.redirectUri']}") String redirectUri, @Value("#{@environment['okta.client.token']}") String token, @Value("#{@environment['okta.client.orgUrl']}") String orgUrl) {
    public Auth(OktaOAuth2Properties oktaOAuth2Properties, OktaClientProperties oktaClientProperties) {
		Assert.notNull (oktaOAuth2Properties.getClientId(),  "Property 'okta.oauth2.clientId' is required.");
    	Assert.notNull (oktaOAuth2Properties.getIssuer(), "Property 'okta.oauth2.issuer' is required.");
    	Assert.notNull (oktaOAuth2Properties.getRedirectUri(),  "Property 'okta.oauth2.redirectUri' is required.");
    	Assert.notNull (oktaClientProperties.getToken(), "Property 'okta.client.token' is required.");
    	Assert.notNull (oktaClientProperties.getOrgUrl(),  "Property 'okta.client.orgUrl' is required.");
    	this.clientId = oktaOAuth2Properties.getClientId();
    	this.issuer = oktaOAuth2Properties.getIssuer();
        this.redirectUri = oktaOAuth2Properties.getRedirectUri();
    	this.token = oktaClientProperties.getToken();
    	this.orgUrl = oktaClientProperties.getOrgUrl();
    	/*this.clientId = clientId;
    	this.issuer = issuer;
        this.redirectUri = redirectUri;
    	this.token = token;
    	this.orgUrl = orgUrl;*/
    }

    @GetMapping("/credentials")
    public WidgetConfig getWidgetConfig() {
        return new WidgetConfig(issuer, clientId, redirectUri);
    }

    public static class WidgetConfig {
    	public String issuer;
    	public String url;
        public String clientId;
        public String redirectUri;

		WidgetConfig(String issuer, String clientId, String redirectUri)  {
        	this.clientId = clientId;
        	this.issuer = issuer;
        	this.url = issuer.replaceAll("/oauth2/.*", "");
        	this.redirectUri = redirectUri;
        }
    }
    
    
    
    @RequestMapping("/403")
    public String error403() {
    	System.err.println("DENTROOOOOOOOOOOOOO   403");
        return "403";
    }
    
    
    
    
    @PostMapping(value="/signup", consumes = { MediaType.APPLICATION_JSON_VALUE })
    //public String signup(@RequestBody String user) {
    public String signup(@Valid @RequestBody com.sierrica.model.User user) {
    	//public String signup(@Valid @ModelAttribute com.sierrica.model.User user) {
    	
    	
    	System.out.println("DENTRO OAUTH BACKEND");
    	
    	//userRepository.save(user);
    	//UserRepository repository = repository.save(user);

    	
    	Client client = Clients.builder()
    	        .setClientCredentials(new TokenClientCredentials(token))
    	        .setOrgUrl(orgUrl)
    	        .build();
    	
    	try {
        	com.okta.sdk.resource.user.User user_okta = UserBuilder.instance()
        	    .setEmail("prueba@example.com")
        	    .setFirstName("Nombre")
        	    .setLastName("Apellido")
        	    .setPassword("Taustemix8888")
        	    .setSecurityQuestion("Favorite security question?")
        	    .setSecurityQuestionAnswer("None of them!")
        	    //.putProfileProperty("division", "Seven") // key/value pairs predefined in the user profile schema
            	.setActive(true)
            	.buildAndCreate(client);
        	
        	String userId = user_okta.getId();
        	System.out.println("User created with ID: " + userId);
        	}
        	catch (com.okta.sdk.resource.ResourceException e) {
        		
        		// User with email already exists
        		if (e.getOktaError().getCode().equals("E0000001") &&
        			e.getOktaError().getMessage().contains("Api validation failed: login") &&   
        			e.getOktaError().getCauses().toString().contains("An object with this field already exists in the current organization")) {
        				return "Un usario ya existe con el email: " + user.getEmail();
        		}
        		else {
        			System.err.println(e);
        			System.err.println(e.getOktaError());
        			return "ERROR DESCONOCIDO";
        		}
        	}


    	return "PRUEBA LLAMADA";
        
    }
}
