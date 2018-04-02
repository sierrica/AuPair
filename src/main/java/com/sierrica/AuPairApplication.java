package com.sierrica;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

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
import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
@EnableEncryptableProperties
//@EnableScheduling
@ComponentScan("com.sierrica")
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@EnableJpaRepositories(basePackages={"com.sierrica.dao"})
//@EnableJpaAuditing
@EnableTransactionManagement
public class AuPairApplication extends SpringBootServletInitializer implements InitializingBean {
	

	
	
	public AuPairApplication() {
        LOG.info("Constructor AuPairApplication");
    }
	
    @PostConstruct
    public void postConstruct() {
        LOG.info("POSTCONTRUCT");
    }
    
	@Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("InitializingBean");
    }
    
    public void init() {
        LOG.info("init-method");
    }
	

	
    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder application) {
		return application.environment(new StandardEncryptableEnvironment()).sources(AuPairApplication.class);		// environment necesario para leer desde logback properties encriptadas
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return configureApplication(application);
	}
	
	/* Run */
    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }
    

    
//	@Bean
//	  public AuditorAware<AuditableUser> auditorProvider() {
//	    return new AuditorAwareImpl();
//	}
	
	
//	@Bean
//  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
//      return new Jackson2ObjectMapperBuilder()
//              .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//  }
	

//	@Bean
//  public AuditDateAware<Instant> auditDateAware() {
//      return new AuditDateAware<Instant>() {
//          @Override
//          public Instant getCurrentDate() {
//              return new Instant();
//          }
//      };
//  }
 
}