package com.sierrica;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
//@EnableScheduling
@ComponentScan("com.sierrica")
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@EnableJpaRepositories(basePackages={"com.sierrica.dao"})
@EnableJpaAuditing
@EnableTransactionManagement

public class AuPairApplication {
	
//	@Bean
//	  public AuditorAware<AuditableUser> auditorProvider() {
//	    return new AuditorAwareImpl();
//	}
//	
	
//	@Bean
//    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
//        return new Jackson2ObjectMapperBuilder()
//                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//    }
	
	
	private static Log logger = LogFactory.getLog(AuPairApplication.class);

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}

		};
	}
	
	
	
	
	/* Run */
    public static void main(String[] args) {
        SpringApplication.run(AuPairApplication.class, args);
    }
}