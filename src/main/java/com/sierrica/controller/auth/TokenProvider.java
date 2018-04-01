package com.sierrica.controller.auth;

import com.sierrica.model.Credentials;
import com.sierrica.model.User;


public interface TokenProvider {

	Credentials getCredentials();
	
	void delete (User user);
	
	void signup (User user);
	
}