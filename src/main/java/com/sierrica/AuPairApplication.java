package com.sierrica;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@SpringBootApplication
@EnableEncryptableProperties
//@EnableScheduling
@ComponentScan("com.sierrica")
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@EnableJpaRepositories(basePackages={"com.sierrica.dao"})
//@EnableJpaAuditing
@EnableTransactionManagement
public class AuPairApplication extends SpringBootServletInitializer {
	
//	@Bean
//	  public AuditorAware<AuditableUser> auditorProvider() {
//	    return new AuditorAwareImpl();
//	}
	
	
//	@Bean
//    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
//        return new Jackson2ObjectMapperBuilder()
//                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//    }
	

//	@Bean
//    public AuditDateAware<Instant> auditDateAware() {
//        return new AuditDateAware<Instant>() {
//            @Override
//            public Instant getCurrentDate() {
//                return new Instant();
//            }
//        };
//    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AuPairApplication.class);
	}
	
	/* Run */
    public static void main(String[] args) {
        SpringApplication.run(AuPairApplication.class, args);
    }
}