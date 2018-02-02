package com.sierrica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import com.sierrica.controller.CustomAccessDeniedHandler;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/*private ResourceServerProperties resource;



	ResourceServerConfig (ResourceServerProperties resource) {
	    this.resource = resource;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
	    resources.resourceId(this.resource.getResourceId());
	}
	*/
	@Override
    public void configure(HttpSecurity http) throws Exception {
		//http.cors().and().authorizeRequests()
		http.cors().and()
		//http.cors().and().authorizeRequests()
			.authorizeRequests().antMatchers(
    			"/",
    	   			
	   			"/manage/**",
	   			
	   			
	   			"/prueba.txt",
	   			"/favicon.ico",
   				"/humans.txt",
		   		"/robots.txt",
		   		"/manifest.json",
		   		"/manifest.webapp",
		   		"/service-worker.js",
		   		"/browserconfig.xml",
		   		"/tile.png",
		   		"/tile-wide.png",
		   		"/images/**",
		   		"/*.css",
		   		"/*.js",
		   		"/index.html",
		   		"/credentials",
		   		"/signin",
		   		"/signup",
		   		"/lib/**",
		   		"/css/**",
		   		"/js/**",
		   		"/img/**",
		   		"/fonts/**")
    		.permitAll()
    	   	.anyRequest().authenticated().and().exceptionHandling()
    	   	.accessDeniedPage("/403")
    	   	;
	}
}