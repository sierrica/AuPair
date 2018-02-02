package com.sierrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sierrica")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class AuPairApplication {

	/* Run */
    public static void main(String[] args) {
        SpringApplication.run(AuPairApplication.class, args);
    }
}