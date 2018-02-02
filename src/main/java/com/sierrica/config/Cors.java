package com.sierrica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import static org.springframework.web.cors.CorsConfiguration.ALL;

/**
 * CORS configuration
 */
@Configuration
public class Cors {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	//registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
                registry.addMapping("/**").allowedMethods(ALL).allowedOrigins(ALL).allowedHeaders(ALL).allowCredentials(true);
            }
        };
    }
}