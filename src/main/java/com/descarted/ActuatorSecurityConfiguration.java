package com.descarted;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2) // before the resource server configuration
public class ActuatorSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.requestMatcher(EndpointRequest.toAnyEndpoint())
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.httpBasic();
		// @formatter:on
	}*/

}