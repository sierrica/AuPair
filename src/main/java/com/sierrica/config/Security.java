package com.sierrica.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;


import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;

/**
 * Security configuration
 */


@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)

//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
//@EnableOAuth2Client
//@EnableOAuth2Sso
//@EnableAuthorizationServer
public class Security extends GlobalMethodSecurityConfiguration {
	//public class Security  {

	/**
	 * Global Security
	 */
	// NUNCA ENTRA. NO SE SI REALMENTE FUNCIONA
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
       return new OAuth2MethodSecurityExpressionHandler();
	}
}