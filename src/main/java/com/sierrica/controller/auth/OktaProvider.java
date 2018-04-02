package com.sierrica.controller.auth;

import org.springframework.util.Assert;
import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.spring.config.OktaClientProperties;
import com.okta.spring.config.OktaOAuth2Properties;
import com.sierrica.exception.custom.InvalidInputException;
import com.sierrica.model.Credentials;
import com.sierrica.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    public Credentials getCredentials() {
    	Credentials credentials = new Credentials("okta");
    	credentials.setClientId (oktaOAuth2Properties.getClientId());
    	credentials.setIssuer (oktaOAuth2Properties.getIssuer());
    	credentials.setUrl (oktaOAuth2Properties.getIssuer().replaceAll("/oauth2/.*", ""));
    	credentials.setRedirectUri (oktaOAuth2Properties.getRedirectUri());
    	return credentials;
    }



	@Override
	public void signup(User user) throws InvalidInputException, RuntimeException {
		Client client = Clients.builder()
			.setClientCredentials(new TokenClientCredentials(oktaClientProperties.getToken()))
			.setOrgUrl(oktaClientProperties.getOrgUrl())
		    .build();

    	try {
			com.okta.sdk.resource.user.User user_okta = UserBuilder.instance()
		    	    .setEmail(user.getEmail())
		    	    .setFirstName(user.getFirstName())
		    	    .setLastName(user.getLastName())
		    	    .setPassword(user.getPassword())
		    	    .setSecurityQuestion(user.getSecurityQuestion())
		    	    .setSecurityQuestionAnswer(user.getSecurityQuestionAnswer())
		        	.setActive(true)
		        	.buildAndCreate(client);
			System.out.println("User created with ID: " + user_okta.getProfile().getEmail());
		
			
			
			/*
				JwtVerifier jwtVerifier = new JwtHelper()
					    .setIssuerUrl("https://{yourOktaDomain}.com/oauth2/default")
					    .setAudience("api://default")  // defaults to 'api://default'
					    .setConnectionTimeout(1000)    // defaults to 1000ms
					    .setReadTimeout(1000)          // defaults to 1000ms
					    .setClientId("your_client_id") // optional
					    .build();
			*/
			
			  
			
			
			
			
    		//"rwh3vH166HCH/NT9XV5FYu"
    		//qaMqvAPULkbiQzkTCWo5XDcvzpk8Tna
    		//TextEncryptor encryptor = Encryptors.text("password", "991239bab013");
    		//String prueba_prueba = encryptor.encrypt("1234567890");
//    		String gensalt = BCrypt.gensalt();
//    		String salt = KeyGenerators.string().generateKey();
//    		BytesEncryptor prueba_encript = Encryptors.standard("tauste", salt);
//    		//Encryptors.text("password", "salt");
//    		byte[] prueba_encript2 = prueba_encript.encrypt(user.getPassword().getBytes());
//    		String password2 = user.getPassword();
//    		//@Autowired 
//    		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    		final String encodedPassword = passwordEncoder.encode(password2);
//    		gensalt = salt;
//    		String passwordCrypted = BCrypt.hashpw(user.getPassword(), gensalt);
//    		String passwordCryptedClean = passwordCrypted.replace(gensalt, "");
//    		user.setPassword(passwordCryptedClean);
//    		
//        	user.setStatus(StatusType.ACTIVE);
//        	user.setLocale(LocaleType.es);
//        	userRepository.save(user);


//    		JSONObject json = new JSONObject();
//    		
//    		JSONObject profile = new JSONObject();
//    		profile.put("firstName", user.getFirstName());
//    		profile.put("lastName", user.getLastName());
//    		profile.put("email", user.getEmail());
//    		profile.put("login", user.getEmail());
//    		json.put("profile", profile);
//    		
//    		JSONObject credentials = new JSONObject();
//    		JSONObject password = new JSONObject();
//    		JSONObject hash = new JSONObject();
//    		hash.put("algorithm", "BCRYPT");
//    		hash.put("workFactor", 10);
//    		hash.put("salt", "rwh3vH166HCH/NT9XV5FYu");
//    		hash.put("value", "qaMqvAPULkbiQzkTCWo5XDcvzpk8Tna");
//    		password.put("hash", hash);
//    		credentials.put("password", password);
//    		json.put("credentials", credentials);
//
//            URL url = new URL(oktaClientProperties.getOrgUrl() + "/api/v1/users?activate=true");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            connection.setRequestProperty("Authorization", "SSWS " + oktaClientProperties.getToken());
//            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
//            writer.write(json.toString());
//            writer.close();
//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuffer jsonString = new StringBuffer();
//            String line;
//            while ((line = br.readLine()) != null)
//                    jsonString.append(line);
//            
//            br.close();
//            connection.disconnect();
//            
//            JSONObject jsonResponse = new JSONObject(jsonString.toString());
//            System.out.println("OKTA id: " + jsonResponse.get("id"));
//        	System.out.println("User created with ID: " + user.getEmail());
        	
    	}
    	
    	catch (com.okta.sdk.resource.ResourceException e) {
    		if (e.getOktaError().getCode().equals("E0000001") &&
    			e.getOktaError().getMessage().contains("Api validation failed: login") &&
    			e.getOktaError().getCauses().toString().contains("An object with this field already exists in the current organization")) {
    				LOG.error("Trying signup with an email already registered in tokenProvider: Okta");
    				throw new InvalidInputException("userAlreadyRegistered");
    		}
    		else if (e.getOktaError().getCode().equals("E0000001") &&
        			e.getOktaError().getMessage().contains("Api validation failed: customSecurityQuestion") &&
        			e.getOktaError().getCauses().toString().contains("The security question answer is too weak, answer must not be part of the question")) {
    					throw new InvalidInputException("answerPartQuestion");

        	}
    		else if (e.getOktaError().getCode().equals("E0000001") &&
        			e.getOktaError().getMessage().contains("Api validation failed: com.saasure.core.services.user.InvalidUserProfileException") &&
        			e.getOktaError().getCauses().toString().contains("Password requirements were not met. Password requirements: at least 8 characters, a lowercase letter, an uppercase letter, a number, no parts of your username")) {
    					throw new InvalidInputException("passwordNotValid");
        	}
    		else {
    			System.err.println(e);
    			throw new RuntimeException(e.getOktaError().getMessage());
    		}
    	}
	}
	
	
    @Override
    public void delete(User user) {
    	Client client = Clients.builder()
    	        .setClientCredentials(new TokenClientCredentials(oktaClientProperties.getToken()))
    	        .setOrgUrl(oktaClientProperties.getOrgUrl())
    	        .build();
    	try {
        	client.getUser(user.getEmail()).deactivate();
        	client.getUser(user.getEmail()).delete();
    	}
    	catch (com.okta.sdk.resource.ResourceException e) {
    		LOG.error("Unable to eliminate user: " + user.getEmail() + ", in tokenProvider: Okta");
    		LOG.error(e.getStackTrace().toString());
    		throw new RuntimeException("Unable to eliminate user: " + user.getEmail() + ", in tokenProvider: Okta");
    	}
    }
	
}