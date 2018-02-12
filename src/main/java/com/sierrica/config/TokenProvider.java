package com.sierrica.config;



public interface TokenProvider {

	String getCredentials();
	
	String signup (com.sierrica.model.User user);
	
}