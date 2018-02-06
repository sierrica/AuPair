package com.sierrica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * ResourceServerConfigurerAdapter configuration
 */
@Configuration
@EnableResourceServer
//@Order(ManagementServerProperties.BASIC_AUTH_ORDER)
//@Order(15)
//@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	

	
	
//	@Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        	resources.resourceId("blah");
//    }
//	private ResourceServerProperties resourceServerProperties;
//			
//			@Autowired
//			public ResourceServerConfig(ResourceServerProperties resourceServerProperties) {
//				this.resourceServerProperties = resourceServerProperties;
//			}
//
//			@Override
//			public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//				resources.resourceId(resourceServerProperties.getId());
//				resources.stateless(false);
//				super.configure(resources);
//			}

	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		//http.cors().and().authorizeRequests()
		
		
		/*http
		.authorizeRequests()
		.antMatchers("/**").access("#oauth2.hasScope('api.read')");*/
		

		
		http.cors().and()
		//http.cors().and().authorizeRequests()
			
		
		/*.authorizeRequests()
			.antMatchers("/mod"
			).authenticated().anyRequest().permitAll()
			//.access("#oauth2.hasScope('write') " + "and #oauth2.clientHasRole('ROLE_CLIENT') " + "and hasRole('USER')")
			;*/
		
		
		
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
    	   	.anyRequest()
    	   	//.access("hasAuthority('Everyone') || #oauth2.hasScope('email')");
			.authenticated()
			//.and().httpBasic()
			//.and().exceptionHandling()
			//.accessDeniedPage("/403")
;
		
		
    	   	
	}
}