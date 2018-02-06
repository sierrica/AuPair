package com.sierrica;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

@Value("#{@environment['okta.client.token']}") String token;
@Value("#{@environment['okta.client.orgUrl']}") String orgUrl;
	
@Autowired
private MockMvc mockMvc;


    @Test
    @Ignore
	public void _01_getIndex() throws Exception {
    	System.out.println("DENTRO getIndex");
        this.mockMvc.perform(get("/"))
                    .andExpect(status().isOk());
    }
    
    @Test
    @Ignore
	public void _02_getCredentials() throws Exception {
    	System.out.println("DENTRO getCredentials");
        this.mockMvc.perform(get("/credentials"))
                    .andExpect(status().isOk());
                	//.andExpect(content().string(containsString("Hello World")));
    }
    
    @Test
	public void _03_deleteUser()  {
    	System.out.println("DENTRO deleteUser");
        
    	
    	Client client = Clients.builder()
    	        .setClientCredentials(new TokenClientCredentials(token))
    	        .setOrgUrl(orgUrl)
    	        .build();
    	
    	try {
        	client.getUser("prueba@example.com").deactivate();
        	client.getUser("prueba@example.com").delete();
    	}
//    	catch (java.net.UnknownHostException f) {
//    		System.err.println("ERROR DE CONEXION CON OKTA");
//    	}
    	catch (com.okta.sdk.resource.ResourceException e) {
    		System.err.println("No existe ese usuario");
    		throw e;
    	}


    }
    

    @Test
	public void _04_signUp() throws Exception {
    	System.out.println("DENTRO signup");
    	
    	JSONObject json = new JSONObject();
    	json.put("email","prueba@hotmail.com");
//    	json.put("firstName","Nombre");
//    	json.put("lastName","Apellido");
//    	json.put("password", "Taustemix8888");
//    	json.put("securityQuestion", "Nombre Padre");
//    	json.put("securityQuestionAnswer", "Jesus");
    	//JSONObject json2 = new JSONObject();
    	//json.put("user",json);
    	
    	
    	String prueba = "{ \"email\": \"prueba@example.com" +  "\"}";
    	
        
    	this.mockMvc.perform(post("/signup").contentType(MediaType.APPLICATION_JSON_VALUE).content(prueba))
    				//.andDo(print())
    				.andExpect(status().isOk());
                	//.andExpect(content().string(containsString("Hello World")));
    }

}
