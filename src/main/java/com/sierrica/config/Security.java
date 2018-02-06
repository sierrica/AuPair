package com.sierrica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;


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