package com.sierrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
//@EnableScheduling
@ComponentScan("com.sierrica")
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@EnableJpaRepositories(basePackages={"com.sierrica.dao"})
public class AuPairApplication {
	
	
	@Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
	
	/* Run */
    public static void main(String[] args) {
        SpringApplication.run(AuPairApplication.class, args);
    }
}