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
//@EnableOAuth2Sso
//@EnableOAuth2Client 
public class Security {
	
	/**
	 * Global Security
	 */
	
	protected static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
	   protected MethodSecurityExpressionHandler createExpressionHandler() {
	       return new OAuth2MethodSecurityExpressionHandler();
	   }
	}
}